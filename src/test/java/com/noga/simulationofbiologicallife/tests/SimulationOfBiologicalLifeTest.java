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
	public void testTimeConverter() {
		TimeConverter time1 = new TimeConverter(60 * 24 * 365);
		
		assertEquals("ќшибочное кол-во часов", 24 * 365, time1.getTime(TimeInterval.HOUR));
		assertEquals("ќшибочное кол-во дней", 365, time1.getTime(TimeInterval.DAY));
		assertEquals("ќшибочное кол-во недель", 52, time1.getTime(TimeInterval.WEEK));
		assertEquals("ќшибочное кол-во мес€цев", 12, time1.getTime(TimeInterval.MONTH));
		assertEquals("ќшибочное кол-во лет", 1, time1.getTime(TimeInterval.YEAR));
		
		TimeConverter time2 = new TimeConverter(365 * 60 * 24 + 2324);
		
		assertEquals("ќшибочный вывод времени в строку", "1 (г.) 1 (дн.) 14 (ч.) 44 (мин.)", time2.toString());
	}
}