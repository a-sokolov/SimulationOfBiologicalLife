package com.noga.simulationofbiologicallife.core;

import static com.noga.simulationofbiologicallife.core.TimeInterval.*;

/**
 * Конвертирование игрового времени (минуты) в следующие форматы:
 * <ul><li>Минуты
 * <li>Часы
 * <li>Дни
 * <li>Недели
 * <li>Месяца
 * <li>Года</ul>
 * @author NOGA
 * @version 1.0
 */
public class TimeConverter {
	/** Текущее игровое время в минутах */
	private int minutes;
	/** Игровое время в часах */ 
	private int hours;
	/** Игровое время в днях */
	private int days;
	/** Игровое время в неделях */
	private int weeks;
	/** Игровое время в месяцах */
	private int months;
	/** Игровое время в годах */
	private int years;
	
	/**
	 * Конструктор
	 * @param time Время в игровых минутах
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
	 * Чтение игрового времени в указанном интервале.
	 * @param interval Интервал
	 * @return Время в зависимости от {@link TimeInterval}
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
			default: throw new Error("Неподдерживаемое значение перечисления TimeInterval: " + interval);
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
