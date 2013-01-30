package com.noga.simulationofbiologicallife.core;

/**
 * ������������ ��������� ����������.
 * @author NOGA
 * @version 1.0
 */
public enum TimeInterval {
	MINUTE(1, "���.")
	, HOUR(60, "�.")
	, DAY(60 * 24, "��.")
	, WEEK(60 * 24 * 7, "���.")
	, MONTH(60 * 24 * 30, "���.")
	, YEAR(60 * 24 * 365, "�.")
	, INFINITY(-1, "�������������");
	
	private final int minutes;
	private final String description;
	
	private TimeInterval(int minutes, String description) {
		this.minutes = minutes;
		this.description = description;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public String getDescription() {
		return description;
	}
}
