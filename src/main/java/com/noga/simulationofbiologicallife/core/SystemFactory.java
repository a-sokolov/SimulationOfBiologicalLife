package com.noga.simulationofbiologicallife.core;

/**
 * Фабрика систем
 * @author sbt-sokolov-av
 * @version 1.0
 */
public abstract class SystemFactory {
	/**
	 * Создание системы
	 * @param system Система (перечисление)
	 * @param model Ссылка на модель
	 * @return Система созданная фабрикой
	 * @see System
	 * @see Model
	 */
	public abstract ModelSystem createSystem(Systems system, Model model);
}
