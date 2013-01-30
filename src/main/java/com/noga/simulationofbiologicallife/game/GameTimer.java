package com.noga.simulationofbiologicallife.game;

import org.apache.log4j.Logger;

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
 * @see TimeInterval
 */
public class GameTimer extends Thread {
	/** ������ */
	private static final Logger LOG = Logger.getLogger(GameTimer.class);
	/** ����� ����� � ������������� */
	private static final int DELAY_PERIOD = 1000;
	/** ����� ����������� */
	private static final int NOTICE_PERIOD = 2;

	/** ������� ������� � ������� ������� */
	private long currentTime;
	/** ���� �����*/
	private boolean pause = false;
	/** ���� ��������� ������� */
	private boolean stop = false;
	/** ���� ����������� �������� �������*/
	private boolean showTime = false;
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
		this(game,  false);
	}
	
	/**
	 * �����������
	 * @param game ������ �� ����������� �����
	 * @param showTime true - ���������� ����� ������� � ����
	 * @see Game
	 */
	public GameTimer(Game game, boolean showTime) {
		this.game = game;
		this.showTime = showTime;
	}
	
	@Override
	public void run() {
		// �������� ������� �������
		currentTime = 0L;
		
		int loops;	
		
		while(!(isInterrupted() || stop)) {
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
				// ������� �� �����
				//currentTime--; 
				break;
			}
			
			if (showTime) LOG.info("Time is " + currentTime);
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
	
	/**
	 * ���� ��������� ������
	 */
	public synchronized void stopTimer() {
		stop = true;
	}
}
