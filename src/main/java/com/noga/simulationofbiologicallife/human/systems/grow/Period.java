package com.noga.simulationofbiologicallife.human.systems.grow;

class Period {
	private int from;
	private int to;
	
	public Period (int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}
