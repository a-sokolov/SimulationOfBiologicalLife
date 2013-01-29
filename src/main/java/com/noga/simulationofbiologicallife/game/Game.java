package com.noga.simulationofbiologicallife.game;

import org.apache.log4j.Logger;

import com.noga.simulationofbiologicallife.core.TimeConverter;
import com.noga.simulationofbiologicallife.core.TimeInterval;

/**
 * �����, ������� �������� �� ������ � ���������� �����.<br>
 * ������ ����� ���� ������ ���������� � �������� ���� ���������� ������.
 * <p>������:<br>
 * <i>Game game = new Game("test game");<br>
 * game.start();<br>
 * ...<br>
 * game.stop();</i>
 * @author NOGA
 * @version 1.0
 * @see GameBody
 */
public class Game {
	/** ������ */
	private static final Logger LOG = Logger.getLogger(Game.class);
	/** �������� ���� */
	private String name;
	/** ������ �� ������� ������ {@link GameTimer} */
	private GameTimer timer;
	/** ������ �� ���� ���� {@link GameBody} */
	private GameBody body;
	
	/**
	 * �����������
	 * @param name �������� ������� ����
	 * @param body ���� ����
	 * @see GameTimer
	 * @see GameBody
	 */
	public Game(String name, GameBody body) {
		this(name, body, false);
	}
	
	/**
	 * �����������
	 * @param name �������� ������� ����
	 * @param body ���� ����
	 * @param showTime true - ���������� ����� ������� � ����
	 * @see GameTimer
	 * @see GameBody
	 */
	public Game(String name, GameBody body, boolean showTime) {
		timer = new GameTimer(this, showTime);
		this.name = name;
		this.body = body;
	}
	
	/**
	 * ������ �������� ����
	 * @return �������� ����
	 */
	@Deprecated
	public String getName() {
		return name;
	}
	
	/**
	 * ������ �������� ������� � ������� �������
	 * @return �������� ��������
	 */
	public TimeConverter getTime() {
		return new TimeConverter(timer.getTime());
	}
	
	/** ����� */
	public void start() {
		body.prepare();
		timer.start();
		LOG.info("Game started");
	}
	
	/** ����� */
	public void pause() {
		try {
			timer.pause();
			LOG.info("Game paused");
		} catch (InterruptedException e) {
			LOG.error(e);
		}
	}
	
	/** ���������� */
	public void resume() {
		timer.restore();
		LOG.info("Game resumed");
	}
	
	/** ���������� */
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
	 * ���������� ��������� ��������
	 * @param interval ��������� ��������
	 * @see TimeInterval
	 */
	public void setInterval(TimeInterval interval) {
		timer.setInterval(interval);
	}
	
	/** ����������� � ��� ��� ��������� ��������� �������� ���� */
	public void update() {
		body.update(this);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
