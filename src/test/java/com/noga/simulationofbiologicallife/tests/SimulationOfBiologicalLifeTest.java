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
		assertEquals("��������� ��� ������", "heart", organ.getName());
	}
	
	@Test
	public void testTimeConverter() {
		TimeConverter time1 = new TimeConverter(60 * 24 * 365);
		
		assertEquals("��������� ���-�� �����", 24 * 365, time1.getTime(TimeInterval.HOUR));
		assertEquals("��������� ���-�� ����", 365, time1.getTime(TimeInterval.DAY));
		assertEquals("��������� ���-�� ������", 52, time1.getTime(TimeInterval.WEEK));
		assertEquals("��������� ���-�� �������", 12, time1.getTime(TimeInterval.MONTH));
		assertEquals("��������� ���-�� ���", 1, time1.getTime(TimeInterval.YEAR));
		
		TimeConverter time2 = new TimeConverter(365 * 60 * 24 + 2324);
		
		assertEquals("��������� ����� ������� � ������", "1 (�.) 1 (��.) 14 (�.) 44 (���.)", time2.toString());
	}
}