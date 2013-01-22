package com.noga.simulationofbiologicallife.core;

/**
 * ������� ������
 * @author sbt-sokolov-av
 * @version 1.0
 */
public abstract class SystemFactory {
	/**
	 * �������� �������
	 * @param system ������� (������������)
	 * @param model ������ �� ������
	 * @return ������� ��������� ��������
	 * @see System
	 * @see Model
	 */
	public abstract ModelSystem createSystem(Systems system, Model model);
}
