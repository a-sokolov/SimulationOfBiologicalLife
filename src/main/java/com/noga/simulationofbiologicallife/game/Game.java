package com.noga.simulationofbiologicallife.game;

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
		timer = new GameTimer(this);
		
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
	public long getTime() {
		return timer.getTime();
	}
	
	/** ����� */
	public void start() {
		timer.start();
		System.out.println("Game is started");
	}
	
	/** ����� */
	public void pause() {
		try {
			timer.pause();
			System.out.println("Game is paused");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/** ���������� */
	public void resume() {
		timer.restore();
		System.out.println("Game is resumed");
	}
	
	/** ���������� */
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
