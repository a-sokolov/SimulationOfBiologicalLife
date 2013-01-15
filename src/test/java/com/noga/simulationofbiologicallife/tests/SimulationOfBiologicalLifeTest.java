package com.noga.simulationofbiologicallife.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.noga.simulationofbiologicallife.core.Organ;
import com.noga.simulationofbiologicallife.game.GameTimeConverter;
import com.noga.simulationofbiologicallife.game.TimeInterval;

public class SimulationOfBiologicalLifeTest {
	@Test
	public void testOrgan() {
		Organ organ = new Organ("heart");
		assertEquals("ќшибочное им€ органа", "heart", organ.getName());
	}
	
	@Test
	public void testGameTimeConverter() {
		GameTimeConverter timeConverter = new GameTimeConverter(525600);
		
		assertEquals("ќшибочное кол-во часов", 8760, timeConverter.getTime(TimeInterval.HOUR));
		assertEquals("ќшибочное кол-во дней", 365, timeConverter.getTime(TimeInterval.DAY));
		assertEquals("ќшибочное кол-во недель", 52, timeConverter.getTime(TimeInterval.WEEK));
		assertEquals("ќшибочное кол-во мес€цев", 12, timeConverter.getTime(TimeInterval.MONTH));
		assertEquals("ќшибочное кол-во лет", 1, timeConverter.getTime(TimeInterval.YEAR));
	}
}