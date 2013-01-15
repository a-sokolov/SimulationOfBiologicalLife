package com.noga.simulationofbiologicallife.game;

import static com.noga.simulationofbiologicallife.game.TimeInterval.*;

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
public class GameTimeConverter {
	/** Текущее игровое время в минутах */
	private long minutes;
	/** Игровое время в часах */ 
	private long hours;
	/** Игровое время в днях */
	private long days;
	/** Игровое время в неделях */
	private long weeks;
	/** Игровое время в месяцах */
	private long months;
	/** Игровое время в годах */
	private long years;
	
	/**
	 * Конструктор
	 * @param time Время в игровых минутах
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
	 * Чтение игрового времени в указанном интервале.
	 * @param interval Интервал
	 * @return Время в зависимости от {@link TimeInterval}
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
			default: throw new Error("Неподдерживаемое значение перечисления TimeInterval: " + interval);
		}
		
		return value;
	}
}
