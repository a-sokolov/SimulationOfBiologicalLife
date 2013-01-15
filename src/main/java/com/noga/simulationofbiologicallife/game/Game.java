package com.noga.simulationofbiologicallife.game;

import java.util.Observable;

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
 * @see Observable
 */
public class Game extends Observable {
	/** �������� ���� */
	private String name;
	/** ������ �� ������� ������ {@link GameTimer} */
	private GameTimer timer;
	
	/**
	 * �����������
	 * @param name �������� ������� ����
	 * @see GameTimer
	 */
	public Game(String name) {
		timer = new GameTimer(this);
		this.name = name;
	}
	
	/**
	 * ������ �������� ����
	 * @return �������� ����
	 */
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
	
	/** ����������� ���������� � ��� ��� ��������� ��������� �������� ���� */
	public void update() {
		setChanged();
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return name;
	}
}
