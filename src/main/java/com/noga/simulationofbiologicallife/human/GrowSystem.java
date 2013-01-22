package com.noga.simulationofbiologicallife.human;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.ModelSystem;
import com.noga.simulationofbiologicallife.core.TimeConverter;

/**
 * Человеческая система роста
 * @author sbt-sokolov-av
 * @version 1.0
 * @see Model
 */
public class GrowSystem extends ModelSystem {
	/**
	 * Конструктор
	 * @param model Модель
	 * @see Model
	 */
	public GrowSystem(Model model) {
		super(model);
	}
	
	@Override
	public void updateInterval(TimeConverter time) {
		//
	}
	
	/**
	 * Перечисление возрастной периодизации онтогенеза человека
	 * @author NOGA
	 */
	private enum Periods {
		NEWBORN("Новорожденный")
		, BABY("Грудной возраст")
		, INFANCY("Раннее детство")
		, FIRST_CHILDHOOD("Первое детство")
		, SECOND_CHILDHOOD("Второе детство")
		, TEENS("Подростковый возраст")
		, ADOLESCENCE("Юношеский возраст")
		, FIRST_ADULTHOOD("Зрелый возраст (1-й период)")
		, SECOND_ADULHOOD("Зрелый возраст (2-й период)")
		, ADVANCED_AGE("Пожилой возраст")
		, SENIUM("Старческий возраст")
		, LONG_LIVER("Долгожители");
		
		private String description;
		private int daysFrom;
		private int daysTo;
		
		private Periods(String description) {
			this(description, 0, 0);
		}
		
		private Periods(String description, int daysFrom, int daysTo) {
			this.description = description;
			this.daysFrom = daysFrom;
			this.daysTo = daysTo;
		}
		
		public String getDescription() {
			return description;
		}
	}
}
