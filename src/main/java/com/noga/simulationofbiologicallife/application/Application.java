package com.noga.simulationofbiologicallife.application;

import java.util.List;
import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.noga.simulationofbiologicallife.game.Game;
import com.noga.simulationofbiologicallife.game.GameBody;
import com.noga.simulationofbiologicallife.human.Human;
import com.noga.simulationofbiologicallife.human.HumanSystemFactory;
import com.noga.simulationofbiologicallife.ref.lifeexpectancy.Entry;
import com.noga.simulationofbiologicallife.ref.lifeexpectancy.LifeExpectancy;
import com.noga.simulationofbiologicallife.core.Sex;
import com.noga.simulationofbiologicallife.core.TimeInterval;

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
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Serializer serializer = new Persister();
		File source = new File("C:\\MyJava\\workspace\\SimulationOfBiologicalLife\\resource\\lifeexpectancy.xml");

		LifeExpectancy example = serializer.read(LifeExpectancy.class, source);
		System.out.println(example);
		
		List<Entry> entries = example.getEntries();
		
		for(Entry e : entries) {
			System.out.println(e);
		}
		
//		System.out.println("Welcome to Simulation Of Biological Life");
//		
//		GameBody body = new GameBody(new Human(Sex.MAN, new HumanSystemFactory()));
//		Game game = new Game("new game", body);
//		
//		game.setInterval(TimeInterval.MONTH);
//		
//		try {
//			game.start();
//			Thread.sleep(30000);
//			game.pause();
//			Thread.sleep(3000);
//			game.resume();
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			game.stop();
//		}
	}
}
