package com.noga.simulationofbiologicallife.ref.lifeexpectancy;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * —редн€€ продолжительность жизни
 * @author sbt-sokolov-av
 * @version 1.0
 */
@Root
public class LifeExpectancy {
	private static final String OUTPUT = "version = %s, count of entries = %d";
	
	@Attribute
	private float version;
	
	@ElementList(name="list")
	private List<Entry> entries;
	
	public float getVersion() {
		return version;
	}

	public List<Entry> getEntries() {
		return entries;
	}
	
	@Override
	public String toString() {
		return String.format(OUTPUT, version, entries.size());
	}
}
