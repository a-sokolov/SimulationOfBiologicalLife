package com.noga.simulationofbiologicallife.game;

import com.noga.simulationofbiologicallife.core.Model;

/**
 * ���� ����, ������� ������� ������������ {@link Game} � � ������
 * ���������� ������, ��������� ����� ����� ������.
 * @author NOGA
 * @version 1.0
 * @see Game
 * @see Model
 */
public class GameBody {
	/** ������ �� ������ {@link Model} */
	private Model model;
	/** ������ �� ��������� ���� {@link GameLiveCycle} */
	private GameLiveCycle gameCycle;
	
	/**
	 * �����������
	 * @param model ������ �� ������ {@link Model}
	 */
	public GameBody(Model model) {
		this.model = model;
		gameCycle = new GameLiveCycle();
	}
	
	/**
	 * ���������� ������ �� ������� ������� ����
	 * @see Model
	 */
	public void prepare() throws Exception {
		gameCycle.prepare(model);
		model.prepare();
	}
	
	/**
	 * �������� ���� ����
	 * @see Model
	 */
	public void close() {
		model.die();
		model.close();
	}
	
	/**
	 * �������� ���������� ������ ������
	 * @param game ������� ����
	 * @see Model
	 */
	public void update(Game game) {
		model.update(game.getTime());
		
		if (!gameCycle.isAlive(model)) {
			game.stop();
			return;
		}
	}
}
