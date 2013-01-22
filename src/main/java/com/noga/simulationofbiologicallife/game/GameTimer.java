package com.noga.simulationofbiologicallife.game;

import com.noga.simulationofbiologicallife.core.TimeInterval;

/**
 * ������� ������. ��-���������, ������� ��������� �������
 * ��������� ������� ������.
 * ������ {@link NOTICE_PERIOD} �������� ���� �����������, ��� �����������
 * ������ ����������� �������. 
 * @author NOGA
 * @version 1.0
 * @see Game
 * @see Thread
 */
public class GameTimer extends Thread {
	/** ���-�� ����� � ���� */
	@SuppressWarnings("unused")
	@Deprecated
	private static final int MINUTES_IN_HOUR = 60;
	/** ���-�� ����� � ��� */
	@SuppressWarnings("unused")
	@Deprecated
	private static final int MINUTES_IN_DAY = 1440;
	/** ���-�� ����� � ������ */
	@SuppressWarnings("unused")
	@Deprecated
	private static final int MINUTES_IN_WEEK = 10080;
	
	/** ����� ����� � ������������� */
	private static final int DELAY_PERIOD = 1000;
	/** ���-�� ���� � ������ */
	@SuppressWarnings("unused")
	@Deprecated
	private static final int DAYS_IN_MONTH = 30;
	/** ����� ����������� */
	private static final int NOTICE_PERIOD = 60;
	
	/** ������� ������� � ������� ������� */
	private static long currentTime;
	
	/** ���� �����*/
	private boolean pause = false;
	/** ������ �� ���� */
	private Game game;
	/** ������� �������� */
	private TimeInterval interval = TimeInterval.MINUTE;
	
	/**
	 * �����������
	 * @param game ������ �� ����������� �����
	 * @see Game
	 */
	public GameTimer(Game game) {
		this.game = game;
	}
	
	@Override
	public void run() {
		// �������� ������� �������
		currentTime = 0L;
		
		int loops;	
		
		while(!isInterrupted()) {
			// ������������� ���-�� ��������
			loops = interval.getMinutes();
			
			try {
				// "���������" ����
				for(int i = 0; i < loops; i++) {
					currentTime++;
					
					// ��������, ���� ������ ����������
					if (pause) {
						// ���������� ����������� �����
						synchronized(game) {
							game.notify();
						}
	
						synchronized(this) {
							try {
								// ���� � ������� ������
								wait();
							} finally {
								// ������� ���� "�����"
								pause = false;
							}
						}
					}
					
					// ��������, ��� � ������� �������� ���������� ��������� ����������
					if (currentTime % NOTICE_PERIOD == 0) {
						game.update();
					}
				}
				
				// ���� � ������� ������
				Thread.sleep(DELAY_PERIOD);
			} catch (InterruptedException e) {
				// �������������� ������� � ������� �� �����
				currentTime--; break;
			}
				
			System.out.println("Time is " + currentTime);
		}
	}
	
	/**
	 * ������ �������� ������� � ������� �������
	 * @return �������� ��������
	 */
	public long getTime() {
		return currentTime;
	}
	
	/**
	 * �����. ��� ������ ������ ����������� {@link callback} ����� �������.
	 * @throws InterruptedException
	 */
	public void pause() throws InterruptedException {
		synchronized(game) {
			pause = true;
			game.wait();
		}
	}
	
	/** ���������� */
	public synchronized void restore() {
		notify();
	}
	
	/**
	 * ���������� ��������� ���������
	 * @param interval ��������� ��������
	 * @see TimeInterval
	 */
	public synchronized void setInterval(TimeInterval interval) {
		this.interval = interval;
	}
}
