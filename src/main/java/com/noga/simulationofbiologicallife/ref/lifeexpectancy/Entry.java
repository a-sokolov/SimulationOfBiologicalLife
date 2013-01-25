package com.noga.simulationofbiologicallife.ref.lifeexpectancy;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Entry {
	private static final String OUTPUT = "id = %d, name = %s, avg = %.2f, man = %.2f, woman = %.2f";
	
	@Attribute
	private int id;

	@Attribute
	private String name;

	@Element
	private double avg;
   
	@Element
	private double man;

	@Element
	private double woman;
   
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
   
	public double getAvg() {
		return avg;
	}
   
	public double getMan() {
		return man;
	}
   
	public double getWoman() {
		return woman;
	}
   
	@Override
	public String toString() {
		return String.format(OUTPUT, id, name, avg, man, woman); 
	}
}
