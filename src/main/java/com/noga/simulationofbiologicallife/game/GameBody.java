package com.noga.simulationofbiologicallife.game;

import java.util.Set;
import java.util.HashSet;

import com.noga.simulationofbiologicallife.core.SystemFactory;
import com.noga.simulationofbiologicallife.core.ModelSystem;
import com.noga.simulationofbiologicallife.core.TimeConverter;

/**
 * ���� ����, ������� ������� ������������ {@link Game} � � ������
 * ���������� ������, ��������� ����� ����� ������ �����������.
 * @author NOGA
 * @version 1.0
 * @see Game
 * @see GameTimeConverter
 * @see ModelSystem
 */
public class GameBody {
	/** ��������� ������ */
	private Set<ModelSystem> systems = new HashSet<ModelSystem>();
	private SystemFactory systemFactory;;
	
	/**
	 * �����������
	 * @param systemFactory ������ �� ������� ������ ������
	 */
	public GameBody(SystemFactory systemFactory) {
		this.systemFactory = systemFactory;
	}
	
	/**
	 * �������� ���������� ������ ���� ������ ������
	 * @param game ������� ����
	 * @see TimeConverter
	 * @see ModelSystem
	 */
	public void update(Game game) {
		TimeConverter time = new TimeConverter(game.getTime());
				
		for(ModelSystem system : systems) {
			system.updateInterval(time);
		}
	}
	
	/**
	 * �������� ����� �������
	 * @param system �������
	 * @return ��������� ���������� � ��������� {@link java.util.HashSet}
	 */
	@Deprecated
	public boolean addSystem(ModelSystem system) {
		return systems.add(system);
	}
}
