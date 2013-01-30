package com.noga.simulationofbiologicallife.core;

/**
 * Перечисления временных интервалов.
 * @author NOGA
 * @version 1.0
 */
public enum TimeInterval {
	MINUTE(1, "мин.")
	, HOUR(60, "ч.")
	, DAY(60 * 24, "дн.")
	, WEEK(60 * 24 * 7, "нед.")
	, MONTH(60 * 24 * 30, "мес.")
	, YEAR(60 * 24 * 365, "г.")
	, INFINITY(-1, "бесконечность");
	
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
