package com.noga.simulationofbiologicallife.human;

import com.noga.simulationofbiologicallife.core.SystemFactory;
import com.noga.simulationofbiologicallife.core.ModelSystem;
import com.noga.simulationofbiologicallife.core.Systems;

public class HumanSystemFactory extends SystemFactory {

	@Override
	public ModelSystem createSystem(Systems system) {
		ModelSystem modelSystem = null;
		
		switch(system) {
			case GROW: modelSystem = new GrowSystem(); break;
		}
		
		return modelSystem;
	}
}
