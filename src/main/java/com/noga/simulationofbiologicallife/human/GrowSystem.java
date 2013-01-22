package com.noga.simulationofbiologicallife.human;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.ModelSystem;
import com.noga.simulationofbiologicallife.core.TimeConverter;

/**
 * ������������ ������� �����
 * @author sbt-sokolov-av
 * @version 1.0
 * @see Model
 */
public class GrowSystem extends ModelSystem {

	/**
	 * �����������
	 * @param model ������
	 * @see Model
	 */
	public GrowSystem(Model model) {
		super(model);
	}
	
	@Override
	public void updateInterval(TimeConverter time) {
		//
	}
}
