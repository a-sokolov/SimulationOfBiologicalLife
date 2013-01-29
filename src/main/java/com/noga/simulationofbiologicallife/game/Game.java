package com.noga.simulationofbiologicallife.game;

import org.apache.log4j.Logger;

import com.noga.simulationofbiologicallife.core.TimeConverter;
import com.noga.simulationofbiologicallife.core.TimeInterval;

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
 * @see GameBody
 */
public class Game {
	/** Логгер */
	private static final Logger LOG = Logger.getLogger(Game.class);
	/** Описание игры */
	private String name;
	/** Ссылка на игровой таймер {@link GameTimer} */
	private GameTimer timer;
	/** Ссылка на тело игры {@link GameBody} */
	private GameBody body;
	
	/**
	 * Конструктор
	 * @param name Описание текущей игры
	 * @param body Тело игры
	 * @see GameTimer
	 * @see GameBody
	 */
	public Game(String name, GameBody body) {
		this(name, body, false);
	}
	
	/**
	 * Конструктор
	 * @param name Описание текущей игры
	 * @param body Тело игры
	 * @param showTime true - отображать время таймера в логе
	 * @see GameTimer
	 * @see GameBody
	 */
	public Game(String name, GameBody body, boolean showTime) {
		timer = new GameTimer(this, showTime);
		this.name = name;
		this.body = body;
	}
	
	/**
	 * Чтение описания игры
	 * @return Описание игры
	 */
	@Deprecated
	public String getName() {
		return name;
	}
	
	/**
	 * Чтение счетчика времени в игровых минутах
	 * @return Значение счетчика
	 */
	public TimeConverter getTime() {
		return new TimeConverter(timer.getTime());
	}
	
	/** Старт */
	public void start() {
		body.prepare();
		timer.start();
		LOG.info("Game started");
	}
	
	/** Пауза */
	public void pause() {
		try {
			timer.pause();
			LOG.info("Game paused");
		} catch (InterruptedException e) {
			LOG.error(e);
		}
	}
	
	/** Продолжить */
	public void resume() {
		timer.restore();
		LOG.info("Game resumed");
	}
	
	/** Остановить */
	public void stop() {
		timer.interrupt();
		
		try {
			timer.join();
		} catch (InterruptedException e) {
			LOG.error(e);
		}
		
		body.close();
		
		LOG.info("Game stopped");
		LOG.info("Total time is " + timer.getTime());
	}
	
	/**
	 * Установить временной интервал
	 * @param interval временной интервал
	 * @see TimeInterval
	 */
	public void setInterval(TimeInterval interval) {
		timer.setInterval(interval);
	}
	
	/** Уведомление о том что наступила очередная итерация игры */
	public void update() {
		body.update(this);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
