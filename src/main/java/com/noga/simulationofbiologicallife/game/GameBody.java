package com.noga.simulationofbiologicallife.game;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.HashSet;

/**
 * ���� ����, ������� ������� ������������ {@link Game} � � ������
 * ���������� ������, ��������� ����� ����� ������ �����������.
 * @author NOGA
 * @version 1.0
 * @see Observer
 * @see Game
 * @see GameTimeConverter
 */
public class GameBody implements Observer {
	private Set<ModelSystem> systems = new HashSet<ModelSystem>();
	
	public void update(Observable obs, Object o) {
		if (obs.hasChanged()) {
			if (obs instanceof Game) {
				GameTimeConverter time = new GameTimeConverter(((Game) obs).getTime());
				
				for(ModelSystem system : systems) {
					system.updateInterval(time);
				}
			}
		}
	}
	
	public boolean addSystem(ModelSystem system) {
		return systems.add(system);
	}
}
