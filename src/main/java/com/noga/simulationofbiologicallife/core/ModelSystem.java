package com.noga.simulationofbiologicallife.core;

/**
 * Система модели
 * @author sbt-sokolov-av
 * @version 1.0
 * @see Model
 */
public abstract class ModelSystem {
	/** Ссылка на модель */
	private Model model;
	
	/**
	 * Конструктор
	 * @param model Модель
	 * @see Model
	 */
	public ModelSystem(Model model) {
		this.model = model;
	}
	
	/**
	 * Очередная итерации жизни модели
	 * @param time Ссылка на конвектор времени
	 * @see TimeConverter
	 */
	public abstract void update(TimeConverter time);
	
	/**
	 * Окончание жизненного цикла системы
	 */
	public void die() {
		//	
	}
	
	/**
	 * Инициализация модели 
	 * @return Ссылка на модель
	 * @see Model
	 */
	protected Model getModel() {
		return model;
	}
}
