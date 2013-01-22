package com.noga.simulationofbiologicallife.human;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.SystemFactory;
import com.noga.simulationofbiologicallife.core.Systems;

/**
 * ������ - �������
 * @author sbt-sokolov-av
 * @version 1.0
 * @see Model
 */
public class Human extends Model {
	/**
	 * �����������
	 * @see HumanSystemFactory 
	 */
	public Human() {
		this(new HumanSystemFactory());
	}
	
	/**
	 * �����������
	 * @param systemFactory ������� ������
	 * @see SystemFactory
	 */
	public Human(SystemFactory systemFactory) {
		super(systemFactory);
	}

	@Override
	public void prepare() {
		addSystem(getSystemFactory().createSystem(Systems.GROW, this));
	}
}
