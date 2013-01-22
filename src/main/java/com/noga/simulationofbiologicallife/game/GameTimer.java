package com.noga.simulationofbiologicallife.game;

import com.noga.simulationofbiologicallife.core.TimeInterval;

/**
 * Игровой таймер. По-умолчанию, секунда реального времени
 * равняется игровой минуте.
 * Каждую {@link NOTICE_PERIOD} итерацию идет уведомление, для возможности
 * вызова необходимых событий. 
 * @author NOGA
 * @version 1.0
 * @see Game
 * @see Thread
 */
public class GameTimer extends Thread {
	/** Кол-во минут в часе */
	@SuppressWarnings("unused")
	@Deprecated
	private static final int MINUTES_IN_HOUR = 60;
	/** Кол-во минут в дне */
	@SuppressWarnings("unused")
	@Deprecated
	private static final int MINUTES_IN_DAY = 1440;
	/** Кол-во минут в неделе */
	@SuppressWarnings("unused")
	@Deprecated
	private static final int MINUTES_IN_WEEK = 10080;
	
	/** Время паузы в миллисекундах */
	private static final int DELAY_PERIOD = 1000;
	/** Кол-во дней в месяце */
	@SuppressWarnings("unused")
	@Deprecated
	private static final int DAYS_IN_MONTH = 30;
	/** Время уведомления */
	private static final int NOTICE_PERIOD = 60;
	
	/** Счетчик времени в игровых минутах */
	private static long currentTime;
	
	/** Флаг паузы*/
	private boolean pause = false;
	/** Ссылка на игру */
	private Game game;
	/** Текущий интервал */
	private TimeInterval interval = TimeInterval.MINUTE;
	
	/**
	 * Конструктор
	 * @param game Ссылка на управляющий класс
	 * @see Game
	 */
	public GameTimer(Game game) {
		this.game = game;
	}
	
	@Override
	public void run() {
		// обнуляем счетчик времени
		currentTime = 0L;
		
		int loops;	
		
		while(!isInterrupted()) {
			// инициализация кол-ва итераций
			loops = interval.getMinutes();
			
			try {
				// "Временной" цикл
				for(int i = 0; i < loops; i++) {
					currentTime++;
					
					// проверка, если таймер остановили
					if (pause) {
						// пробуждаем управляющий класс
						synchronized(game) {
							game.notify();
						}
	
						synchronized(this) {
							try {
								// ждем в текущем потоке
								wait();
							} finally {
								// снимаем флаг "пауза"
								pause = false;
							}
						}
					}
					
					// проверка, что в текущей итерации необходимо уведомить слушателей
					if (currentTime % NOTICE_PERIOD == 0) {
						game.update();
					}
				}
				
				// спим в текущем потоке
				Thread.sleep(DELAY_PERIOD);
			} catch (InterruptedException e) {
				// декрементируем счетчик и выходим из цикла
				currentTime--; break;
			}
				
			System.out.println("Time is " + currentTime);
		}
	}
	
	/**
	 * Чтение счетчика времени в игровых минутах
	 * @return Значение счетчика
	 */
	public long getTime() {
		return currentTime;
	}
	
	/**
	 * Пауза. При вызове метода управляющий {@link callback} будет ожидать.
	 * @throws InterruptedException
	 */
	public void pause() throws InterruptedException {
		synchronized(game) {
			pause = true;
			game.wait();
		}
	}
	
	/** Продолжить */
	public synchronized void restore() {
		notify();
	}
	
	/**
	 * Установить временной интеравал
	 * @param interval Временной интервал
	 * @see TimeInterval
	 */
	public synchronized void setInterval(TimeInterval interval) {
		this.interval = interval;
	}
}
