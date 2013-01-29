package com.noga.simulationofbiologicallife.core;

import java.util.Set;
import java.util.HashSet;

import org.apache.log4j.Logger;

/**
 * Модель
 * @author sbt-sokolov-av
 * @version 1.0
 * @see SystemFactory
 * @see ModelSystem
 */
public abstract class Model {
	/** Логгер */
	private static final Logger LOG = Logger.getLogger(Model.class);
	
	/** Фабрика систем  */
	private SystemFactory systemFactory;
	/** Коллекция систем */
	private Set<ModelSystem> systems = new HashSet<ModelSystem>();
	/** Половая принадлежность модели */
	private Sex sex;
	/** Текущее время жизни модели */
	private TimeConverter lifeTime;
	
	/**
	 * Конструктор
	 * @param sex Пол
	 * @param systemFactory Фабрика систем
	 * @see SystemFactory
	 * @see Sex
	 */
	public Model(Sex sex, SystemFactory systemFactory) {
		this.sex = sex;
		this.systemFactory = systemFactory;
	}
	
	public abstract void prepare();

	/**
	 * Закрытие ссылок
	 */
	public void close() {
		//
	}
	
	/**
	 * Обновления данных систем модели
	 * @param time Время жизни модели
	 * @see ModelSystem
	 */
	public void update(TimeConverter time) {
		lifeTime = time;
		for(ModelSystem system : systems) {
			system.update(time);
		}
	}
	
	/**
	 * Добавление новой системы
	 * @param system Система
	 * @see ModelSystem
	 * @return Результат добавления системы в коллекцию
	 */
	public boolean addSystem(ModelSystem system) {
		return systems.add(system);
	}
	
	/**
	 * Инициализация системной фабрики
	 * @return Ссылка на фабрику
	 */
	public SystemFactory getSystemFactory() {
		return systemFactory;
	}
	
	/**
	 * Инициализация половой принадлежности
	 * @return Пол
	 */
	public Sex getSex() {
		return sex;
	}
	
	/**
	 * Смерть модели
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
