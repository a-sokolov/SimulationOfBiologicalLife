package com.noga.simulationofbiologicallife.application;

import com.noga.simulationofbiologicallife.game.Game;
import com.noga.simulationofbiologicallife.game.GameBody;
import com.noga.simulationofbiologicallife.game.TimeInterval;

/**
 * Запуск приложения
 * 
 * @author NOGA
 * @version 1.0
 */
public class Application {
	/**
	 * Точка входа в приложение
	 * @param args Входящие аргументы в виде массива
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Simulation Of Biological Life");
		
		Game game = new Game("test game");
		GameBody body = new GameBody();
		
		game.addObserver(body);
		game.setInterval(TimeInterval.DAY);
		
		try {
			game.start();
			Thread.sleep(5000);
			game.pause();
			Thread.sleep(3000);
			game.resume();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			game.stop();
		}
	}
}
