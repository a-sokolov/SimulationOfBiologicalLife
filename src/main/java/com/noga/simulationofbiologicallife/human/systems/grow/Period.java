package com.noga.simulationofbiologicallife.human.systems.grow;

class Period {
	private int daysFrom;
	private int daysTo;
	
	public Period (int daysFrom, int daysTo) {
		this.daysFrom = daysFrom;
		this.daysTo = daysTo;
	}
	
	public int getDaysFrom() {
		return daysFrom;
	}

	public int getDaysTo() {
		return daysTo;
	}
}
