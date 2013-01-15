package com.noga.simulationofbiologicallife.game;

import java.util.Observable;
import java.util.Observer;

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
	
	public void update(Observable obs, Object o) {
		if (obs.hasChanged()) {
			if (obs instanceof Game) {
				GameTimeConverter timeConverter = new GameTimeConverter(((Game) obs).getTime());
			}
		}
	}
}
