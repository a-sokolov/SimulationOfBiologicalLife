package com.noga.simulationofbiologicallife.game;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.TimeConverter;

/**
 * ���� ����, ������� ������� ������������ {@link Game} � � ������
 * ���������� ������, ��������� ����� ����� ������.
 * @author NOGA
 * @version 1.0
 * @see Game
 * @see GameTimeConverter
 * @see Model
 */
public class GameBody {
	private Model model;
	
	/**
	 * �����������
	 * @param model ������ �� ������ {@link Model}
	 */
	public GameBody(Model model) {
		this.model = model;
	}
	
	/**
	 * �������� ���������� ������ ������
	 * @param game ������� ����
	 * @see TimeConverter
	 * @see Model
	 */
	public void update(Game game) {
		TimeConverter time = new TimeConverter(game.getTime());
		model.update(time);
	}
}
