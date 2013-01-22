package com.noga.simulationofbiologicallife.core;

/**
 * ������� ������
 * @author sbt-sokolov-av
 * @version 1.0
 * @see Model
 */
public abstract class ModelSystem {
	/** ������ �� ������ */
	private Model model;
	
	/**
	 * �����������
	 * @param model ������
	 * @see Model
	 */
	public ModelSystem(Model model) {
		this.model = model;
	}
	
	/**
	 * ��������� �������� ����� ������
	 * @param time ������ �� ��������� �������
	 * @see TimeConverter
	 */
	public abstract void updateInterval(TimeConverter time);
	
	/**
	 * ������������� ������ 
	 * @return ������ �� ������
	 * @see Model
	 */
	protected Model getModel() {
		return model;
	}
}
