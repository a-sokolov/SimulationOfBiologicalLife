package com.noga.simulationofbiologicallife.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.noga.simulationofbiologicallife.core.Organ;

public class SimulationOfBiologicalLifeTest {
	
	@Test
	public void testOrgan() {
		Organ organ = new Organ("heart");
		assertEquals("Incorrect organ name", "heart", organ.getName());
	}
}