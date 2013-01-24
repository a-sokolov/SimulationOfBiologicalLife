package com.noga.simulationofbiologicallife.human;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.SystemFactory;
import com.noga.simulationofbiologicallife.core.ModelSystem;
import com.noga.simulationofbiologicallife.core.Systems;
import com.noga.simulationofbiologicallife.human.systems.grow.GrowSystem;

/**
 * Человеческая фабрика систем
 * @author sbt-sokolov-av
 * @version 1.0
 * @see SystemFactory
 */
public class HumanSystemFactory extends SystemFactory {
	@Override
	public ModelSystem createSystem(Systems system, Model model) {
		ModelSystem modelSystem = null;
		
		switch(system) {
			case GROW: modelSystem = new GrowSystem(model); break;
		}
		
		return modelSystem;
	}
}
