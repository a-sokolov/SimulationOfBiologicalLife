package com.noga.simulationofbiologicallife.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.noga.simulationofbiologicallife.model.Organ;
import com.noga.simulationofbiologicallife.core.TimeConverter;
import com.noga.simulationofbiologicallife.core.TimeInterval;

public class SimulationOfBiologicalLifeTest {
	@Test
	public void testOrgan() {
		Organ organ = new Organ("heart");
		assertEquals("ќшибочное им€ органа", "heart", organ.getName());
	}
	
	@Test
	public void testGameTimeConverter() {
		TimeConverter timeConverter = new TimeConverter(60 * 24 * 365);
		
		assertEquals("ќшибочное кол-во часов", 24 * 365, timeConverter.getTime(TimeInterval.HOUR));
		assertEquals("ќшибочное кол-во дней", 365, timeConverter.getTime(TimeInterval.DAY));
		assertEquals("ќшибочное кол-во недель", 52, timeConverter.getTime(TimeInterval.WEEK));
		assertEquals("ќшибочное кол-во мес€цев", 12, timeConverter.getTime(TimeInterval.MONTH));
		assertEquals("ќшибочное кол-во лет", 1, timeConverter.getTime(TimeInterval.YEAR));
	}
}