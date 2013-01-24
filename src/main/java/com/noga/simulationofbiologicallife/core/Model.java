package com.noga.simulationofbiologicallife.core;

import java.util.Set;
import java.util.HashSet;

/**
 * Модель
 * @author sbt-sokolov-av
 * @version 1.0
 * @see SystemFactory
 * @see ModelSystem
 */
public abstract class Model {
	/** Фабрика систем  */
	private SystemFactory systemFactory;
	/** Коллекция систем */
	private Set<ModelSystem> systems = new HashSet<ModelSystem>();
	/** Половая принадлежность модели */
	private Sex sex;
	
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
	 * Обновления данных систем модели
	 * @param time Время жизни модели
	 * @see ModelSystem
	 */
	public void update(TimeConverter time) {
		for(ModelSystem system : systems) {
			system.updateInterval(time);
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
}
