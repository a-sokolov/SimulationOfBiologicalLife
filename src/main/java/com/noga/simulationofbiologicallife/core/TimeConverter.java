package com.noga.simulationofbiologicallife.core;

import static com.noga.simulationofbiologicallife.core.TimeInterval.*;

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
public class TimeConverter {
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
	public TimeConverter(long time) {
		minutes = time;
		hours = time / HOUR.getMinutes();
		days = time / DAY.getMinutes();
		weeks = time / WEEK.getMinutes();
		months = time / MONTH.getMinutes();
		years = time / YEAR.getMinutes();
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
