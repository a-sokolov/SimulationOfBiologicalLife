package com.noga.simulationofbiologicallife.game;

import static com.noga.simulationofbiologicallife.game.TimeInterval.*;

/**
 * ��������������� �������� ������� (������) � ��������� �������:
 * <ul><li>������
 * <li>����
 * <li>���
 * <li>������
 * <li>������
 * <li>����</ul>
 * @author NOGA
 * @version 1.0
 */
public class GameTimeConverter {
	/** ������� ������� ����� � ������� */
	private long minutes;
	/** ������� ����� � ����� */ 
	private long hours;
	/** ������� ����� � ���� */
	private long days;
	/** ������� ����� � ������� */
	private long weeks;
	/** ������� ����� � ������� */
	private long months;
	/** ������� ����� � ����� */
	private long years;
	
	/**
	 * �����������
	 * @param time ����� � ������� �������
	 */
	public GameTimeConverter(long time) {
		minutes = time;
		hours = time / HOUR.minutes();
		days = time / DAY.minutes();
		weeks = time / WEEK.minutes();
		months = time / MONTH.minutes();
		years = time / YEAR.minutes();
	}
	
	/**
	 * ������ �������� ������� � ��������� ���������.
	 * @param interval ��������
	 * @return ����� � ����������� �� {@link TimeInterval}
	 */
	public long getTime(TimeInterval interval) {
		long value;
		
		switch (interval) {
			case MINUTE: value = minutes; break;
			case HOUR: value = hours; break;
			case DAY: value = days; break;
			case WEEK: value = weeks; break;
			case MONTH: value = months; break;
			case YEAR: value = years; break;
			default: throw new Error("���������������� �������� ������������ TimeInterval: " + interval);
		}
		
		return value;
	}
}
