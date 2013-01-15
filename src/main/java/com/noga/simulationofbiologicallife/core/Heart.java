package com.noga.simulationofbiologicallife.core;

/**
 * ������ 
 * 
 * @author NOGA
 * @version 1.0
 */
public class Heart extends Organ implements Runnable {
	private boolean stop = false;
	
	public Heart() {
		this("heart");
	}
	
	public Heart(String name) {
		super(name);
	}
	
	public void start() {
		while (!stop) {
			System.out.println("���-���");
			
			try {
				Thread.sleep(500);
			} catch (Exception ex) { 
				ex.printStackTrace();
			}
		}
		
		stop = false;
	}
	
	public void stop() {
		stop = true;
	}

	public void run() {
		stop = false;
		start();
	}
}
