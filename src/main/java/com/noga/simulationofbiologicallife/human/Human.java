package com.noga.simulationofbiologicallife.human;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.Sex;
import com.noga.simulationofbiologicallife.core.SystemFactory;
import com.noga.simulationofbiologicallife.core.Systems;

/**
 * Модель - человек
 * @author sbt-sokolov-av
 * @version 1.0
 * @see Model
 */
public class Human extends Model {
	/**
	 * Конструктор
	 * @param systemFactory Фабрика систем
	 * @see SystemFactory
	 */
	public Human(Sex sex, SystemFactory systemFactory) {
		super(sex, systemFactory);
	}
	
	@Override
	public void prepare() {
		addSystem(getSystemFactory().createSystem(Systems.GROW, this));
	}
}
