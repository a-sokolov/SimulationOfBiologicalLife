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
	private int minutes;
	/** ������� ����� � ����� */ 
	private int hours;
	/** ������� ����� � ���� */
	private int days;
	/** ������� ����� � ������� */
	private int weeks;
	/** ������� ����� � ������� */
	private int months;
	/** ������� ����� � ����� */
	private int years;
	
	/**
	 * �����������
	 * @param time ����� � ������� �������
	 */
	public TimeConverter(int time) {
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
	public int getTime(TimeInterval interval) {
		int value;
		
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
	
	@Override
	public String toString() {
		int result;
		int total = minutes;
		String output = "";
		TimeInterval times[] = {YEAR, MONTH, DAY, HOUR, MINUTE};
				
		for(int i = 0; i < times.length; i++) {
			result = total / times[i].getMinutes();
			if (result > 0) {
				total = total % times[i].getMinutes();
				output += (output.length() > 0 ? " " : "") + 
						  String.valueOf(result) + " [" + times[i].getDescription() + "]";
			}
		}
		
		return output;
	}
}
