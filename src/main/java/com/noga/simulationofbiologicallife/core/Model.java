package com.noga.simulationofbiologicallife.core;

import java.util.Set;
import java.util.HashSet;

/**
 * ������
 * @author sbt-sokolov-av
 * @version 1.0
 * @see SystemFactory
 * @see ModelSystem
 */
public abstract class Model {
	/** ������� ������  */
	private SystemFactory systemFactory;
	/** ��������� ������ */
	private Set<ModelSystem> systems = new HashSet<ModelSystem>();
	
	/**
	 * �����������
	 * @param systemFactory ������� ������
	 * @see SystemFactory
	 */
	public Model(SystemFactory systemFactory) {
		this.systemFactory = systemFactory;
	}
	
	public abstract void prepare();
	
	/**
	 * ���������� ������ ������ ������
	 * @param time ����� ����� ������
	 * @see ModelSystem
	 */
	public void update(TimeConverter time) {
		for(ModelSystem system : systems) {
			system.updateInterval(time);
		}
	}
	
	/**
	 * ���������� ����� �������
	 * @param system �������
	 * @see ModelSystem
	 * @return ��������� ���������� ������� � ���������
	 */
	public boolean addSystem(ModelSystem system) {
		return systems.add(system);
	}
	
	/**
	 * ������������� ��������� �������
	 * @return ������ �� �������
	 */
	public SystemFactory getSystemFactory() {
		return systemFactory;
	}
}
