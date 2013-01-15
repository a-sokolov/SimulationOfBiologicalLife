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
		assertEquals("��������� ��� ������", "heart", organ.getName());
	}
	
	@Test
	public void testGameTimeConverter() {
		GameTimeConverter timeConverter = new GameTimeConverter(525600);
		
		assertEquals("��������� ���-�� �����", 8760, timeConverter.getTime(TimeInterval.HOUR));
		assertEquals("��������� ���-�� ����", 365, timeConverter.getTime(TimeInterval.DAY));
		assertEquals("��������� ���-�� ������", 52, timeConverter.getTime(TimeInterval.WEEK));
		assertEquals("��������� ���-�� �������", 12, timeConverter.getTime(TimeInterval.MONTH));
		assertEquals("��������� ���-�� ���", 1, timeConverter.getTime(TimeInterval.YEAR));
	}
}