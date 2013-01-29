package com.noga.simulationofbiologicallife.core;

import java.util.Set;
import java.util.HashSet;

import org.apache.log4j.Logger;

/**
 * ������
 * @author sbt-sokolov-av
 * @version 1.0
 * @see SystemFactory
 * @see ModelSystem
 */
public abstract class Model {
	/** ������ */
	private static final Logger LOG = Logger.getLogger(Model.class);
	
	/** ������� ������  */
	private SystemFactory systemFactory;
	/** ��������� ������ */
	private Set<ModelSystem> systems = new HashSet<ModelSystem>();
	/** ������� �������������� ������ */
	private Sex sex;
	/** ������� ����� ����� ������ */
	private TimeConverter lifeTime;
	
	/**
	 * �����������
	 * @param sex ���
	 * @param systemFactory ������� ������
	 * @see SystemFactory
	 * @see Sex
	 */
	public Model(Sex sex, SystemFactory systemFactory) {
		this.sex = sex;
		this.systemFactory = systemFactory;
	}
	
	public abstract void prepare();

	/**
	 * �������� ������
	 */
	public void close() {
		//
	}
	
	/**
	 * ���������� ������ ������ ������
	 * @param time ����� ����� ������
	 * @see ModelSystem
	 */
	public void update(TimeConverter time) {
		lifeTime = time;
		for(ModelSystem system : systems) {
			system.update(time);
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
	
	/**
	 * ������������� ������� ��������������
	 * @return ���
	 */
	public Sex getSex() {
		return sex;
	}
	
	/**
	 * ������ ������
	 */
	public void die() {
		for(ModelSystem system : systems) {
			system.die();
		}
		LOG.info("Model life time is " + lifeTime.getTime(TimeInterval.YEAR));
		LOG.info("Model die");
	}
	
	public TimeConverter getLifeTime() {
		return lifeTime;
	}
}
