package com.noga.simulationofbiologicallife.game;

import java.util.Observable;

/**
 * Класс, который отвечает за запуск и управление игрой.<br>
 * Каждая новая игра должна начинаться с создания ного экземпляра класса.
 * <p>Пример:<br>
 * <i>Game game = new Game("test game");<br>
 * game.start();<br>
 * ...<br>
 * game.stop();</i>
 * @author NOGA
 * @version 1.0
 * @see Observable
 */
public class Game extends Observable {
	/** Описание игры */
	private String name;
	/** Ссылка на игровой таймер {@link GameTimer} */
	private GameTimer timer;
	
	/**
	 * Конструктор
	 * @param name Описание текущей игры
	 * @see GameTimer
	 */
	public Game(String name) {
		timer = new GameTimer(this);
		this.name = name;
	}
	
	/**
	 * Чтение описания игры
	 * @return Описание игры
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Чтение счетчика времени в игровых минутах
	 * @return Значение счетчика
	 */
	public long getTime() {
		return timer.getTime();
	}
	
	/** Старт */
	public void start() {
		timer.start();
		System.out.println("Game is started");
	}
	
	/** Пауза */
	public void pause() {
		try {
			timer.pause();
			System.out.println("Game is paused");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/** Продолжить */
	public void resume() {
		timer.restore();
		System.out.println("Game is resumed");
	}
	
	/** Остановить */
	public void stop() {
		timer.interrupt();
		
		try {
			timer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Game is stopped");
		System.out.println("Total time is " + timer.getTime());
	}
	
	/**
	 * Установить временной интервал
	 * @param interval временной интервал
	 * @see TimeInterval
	 */
	public void setInterval(TimeInterval interval) {
		timer.setInterval(interval);
	}
	
	/** Уведомление слушателей о том что наступила очередная итерация игры */
	public void update() {
		setChanged();
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return name;
	}
}
