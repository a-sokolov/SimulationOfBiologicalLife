package com.noga.simulationofbiologicallife.application;

import java.text.DecimalFormat;
import java.util.List;
import java.io.File;

import org.apache.log4j.Logger;
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
	private static final Logger LOG = Logger.getLogger(Application.class);
	
	/**
	 * Точка входа в приложение
	 * @param args Входящие аргументы в виде массива
	 * @throws Exception 
	 */
	public static void main(String[] args) {
//		DecimalFormat format = new DecimalFormat(".00");
//		float a = 1111.02f;
//		
//		System.out.println(String.format("bla-bla %s", format.format(a)));
		
		String source = "C:\\MyJava\\workspace\\SimulationOfBiologicalLife\\src\\main\\resources\\lifeexpectancy.txt";
		String target = "C:\\MyJava\\workspace\\SimulationOfBiologicalLife\\src\\main\\resources\\lifeexpectancy.xml";
		
		PrepareLifeExpectancyXML generatorXML = new PrepareLifeExpectancyXML();
		
		try {
			generatorXML.generate(source, target);
			
			Serializer serializer = new Persister();
			LifeExpectancy example = serializer.read(LifeExpectancy.class, new File(target));
			System.out.println(example);
			
			List<Entry> entries = example.getEntries();
			
			for(Entry e : entries) {
				System.out.println(e);
			}
		} catch (Exception ex) {
			LOG.error("Ошибка подготовки данных", ex);
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
