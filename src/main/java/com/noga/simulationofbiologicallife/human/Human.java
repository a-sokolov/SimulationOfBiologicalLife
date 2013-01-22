package com.noga.simulationofbiologicallife.human;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.SystemFactory;
import com.noga.simulationofbiologicallife.core.Systems;

/**
 * Модель - человек
 * @author sbt-sokolov-av
 * @version 1.0
 * @see Model
 * @see Sex
 */
public class Human extends Model {
	/** Пол человека */
	private Sex sex;
	
	/**
	 * Конструктор
	 * @see HumanSystemFactory 
	 */
	public Human(Sex sex) {
		this(new HumanSystemFactory());
		this.sex = sex;
	}
	
	/**
	 * Конструктор
	 * @param systemFactory Фабрика систем
	 * @see SystemFactory
	 */
	public Human(SystemFactory systemFactory) {
		super(systemFactory);
	}
	
	public Sex getSex() {
		return sex;
	}
	
	@Override
	public void prepare() {
		addSystem(getSystemFactory().createSystem(Systems.GROW, this));
	}
}
