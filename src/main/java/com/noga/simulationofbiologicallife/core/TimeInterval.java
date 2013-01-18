package com.noga.simulationofbiologicallife.core;

/**
 * Перечисления временных интервалов.
 * @author NOGA
 * @version 1.0
 */
public enum TimeInterval {
	MINUTE(1), HOUR(60), DAY(60 * 24), WEEK(60 * 24 * 7), MONTH(60 * 24 * 30), YEAR(60 * 24 * 365);
	
	private final int minutes;
	
	private TimeInterval(int minutes) {
		this.minutes = minutes;
	}
	
	public int minutes() {
		return minutes;
	}
}
