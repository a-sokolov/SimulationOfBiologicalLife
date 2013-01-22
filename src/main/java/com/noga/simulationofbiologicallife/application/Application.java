package com.noga.simulationofbiologicallife.application;

import com.noga.simulationofbiologicallife.game.Game;
import com.noga.simulationofbiologicallife.game.GameBody;
import com.noga.simulationofbiologicallife.human.Human;
import com.noga.simulationofbiologicallife.core.TimeInterval;

/**
 * ������ ����������
 * 
 * @author NOGA
 * @version 1.0
 */
public class Application {
	/**
	 * ����� ����� � ����������
	 * @param args �������� ��������� � ���� �������
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Simulation Of Biological Life");
		
		GameBody body = new GameBody(new Human());
		Game game = new Game("new game", body);
		
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
