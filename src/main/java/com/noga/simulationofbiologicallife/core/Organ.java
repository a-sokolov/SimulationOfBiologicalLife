package com.noga.simulationofbiologicallife.core;

/**
 * Орган (др.-греч. — «инструмент») — обособленная совокупность различных 
 * типов клеток и тканей, выполняющая определённую функцию в живом организме. 
 * 
 * @author NOGA
 * @version 1.0
 */
public class Organ {
	/** Наименование органа */
	private String name;
	
	/**
	 * Инициализирует поля {@link Organ#name}
	 * 
	 * @see Organ
	 * @param name Наименование органа
	 */
	public Organ(String name) {
		this.name = name;
	}
	
	/**
	 * Чтение наименования органа {@link Organ#name}
	 * 
	 * @see Organ
	 * @return Наименование органа
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
