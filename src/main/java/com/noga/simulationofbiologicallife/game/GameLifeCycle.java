package com.noga.simulationofbiologicallife.game;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.TimeInterval;
import com.noga.simulationofbiologicallife.ref.lifeexpectancy.Entry;
import com.noga.simulationofbiologicallife.ref.lifeexpectancy.LifeExpectancy;

public class GameLifeCycle {
	/** Ëמדדונ */
	private static final Logger LOG = Logger.getLogger(GameLifeCycle.class);
	
	private Entry lifeExpect;
	private int modelTime;
	
	public void prepare(Model model) throws Exception {
		//String target = "C:\\MyJava\\workspace\\SimulationOfBiologicalLife\\src\\main\\resources\\lifeexpectancy.xml";
		URL url = this.getClass().getClassLoader().getResource("lifeexpectancy.xml");
		File file = new File(url.toURI());
		
		Serializer serializer = new Persister();
		LifeExpectancy example = serializer.read(LifeExpectancy.class, file);
		List<Entry> entries = example.getEntries();
		
		if (entries.size() > 0) {
			Random random = new Random();
			lifeExpect = entries.get(random.nextInt(entries.size()));
			LOG.info(lifeExpect);
			
			switch (model.getSex()) {
				case MAN: modelTime = (int) lifeExpect.getMan(); break; 
				case WOMAN: modelTime = (int) lifeExpect.getWoman(); break;
				default: throw new Exception("Not supported sex type [" + model.getSex() + "]");
			}
			
			int diff = 0;
			diff = Math.abs(modelTime - (int) lifeExpect.getAvg());
			
			if (random.nextInt(1) > 0) {
				modelTime += diff;
			} else {
				modelTime -= diff;
			}
			
			LOG.info("Model time is " + modelTime);
		} else {
			throw new Exception("No data for \"LifeExpectancy\" references");
		}
	}
	
	public boolean isAlive(Model model) {
		return model.getLifeTime().getTime(TimeInterval.YEAR) < modelTime;
	}
}
