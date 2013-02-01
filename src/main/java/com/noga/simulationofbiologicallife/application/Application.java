package com.noga.simulationofbiologicallife.application;

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
	/** Логгер */
	private static final Logger LOG = Logger.getLogger(Application.class);
	
	/**
	 * Точка входа в приложение
	 * @param args Входящие аргументы в виде массива
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		LOG.info("Welcome to Simulation Of Biological Life");
		
		Human human = new Human(Sex.WOMAN, new HumanSystemFactory());
		GameBody body = new GameBody(human);
		Game game = new Game("new game", body, true);
		
		game.setInterval(TimeInterval.YEAR);
		
		try {
			game.start();
			Thread.sleep(300000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			game.stop();
		}
	}
	
	public void PrepareLifeExpectancyXML() {
		String source = "C:\\MyJava\\workspace\\SimulationOfBiologicalLife\\src\\main\\resources\\lifeexpectancy.txt";
		String target = "C:\\MyJava\\workspace\\SimulationOfBiologicalLife\\src\\main\\resources\\lifeexpectancy.xml";
		
		PrepareLifeExpectancyXML generatorXML = new PrepareLifeExpectancyXML();
		
		try {
			generatorXML.generate(source, target);
			
			Serializer serializer = new Persister();
			LifeExpectancy example = serializer.read(LifeExpectancy.class, new File(target));
			LOG.info(example);
			
			List<Entry> entries = example.getEntries();
			
			for(Entry e : entries) {
				LOG.info(e);
			}
		} catch (Exception e) {
			LOG.error("Ошибка подготовки данных", e);
		}
	}
}
