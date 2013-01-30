package com.noga.simulationofbiologicallife.game;

import org.apache.log4j.Logger;

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
 * @see TimeInterval
 */
public class GameTimer extends Thread {
	/** Логгер */
	private static final Logger LOG = Logger.getLogger(GameTimer.class);
	/** Время паузы в миллисекундах */
	private static final int DELAY_PERIOD = 1000;
	/** Время уведомления */
	private static final int NOTICE_PERIOD = 2;

	/** Счетчик времени в игровых минутах */
	private long currentTime;
	/** Флаг паузы*/
	private boolean pause = false;
	/** Флаг остановки таймера */
	private boolean stop = false;
	/** Флаг логирования текущего времени*/
	private boolean showTime = false;
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
		this(game,  false);
	}
	
	/**
	 * Конструктор
	 * @param game Ссылка на управляющий класс
	 * @param showTime true - отображать время таймера в логе
	 * @see Game
	 */
	public GameTimer(Game game, boolean showTime) {
		this.game = game;
		this.showTime = showTime;
	}
	
	@Override
	public void run() {
		// обнуляем счетчик времени
		currentTime = 0L;
		
		int loops;	
		
		while(!(isInterrupted() || stop)) {
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
				// Выходим из цикла
				//currentTime--; 
				break;
			}
			
			if (showTime) LOG.info("Time is " + currentTime);
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
	
	/**
	 * Флаг остановки таймер
	 */
	public synchronized void stopTimer() {
		stop = true;
	}
}
