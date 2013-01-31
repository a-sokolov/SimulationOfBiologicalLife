package com.noga.simulationofbiologicallife.game;

import org.apache.log4j.Logger;

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
	/** ������ */
	private static final Logger LOG = Logger.getLogger(GameBody.class);
	
	/** ������ �� ������ {@link Model} */
	private Model model;
	/** ������ �� ��������� ���� {@link GameLiveCycle} */
	private GameLifeCycle gameCycle;
	
	/**
	 * �����������
	 * @param model ������ �� ������ {@link Model}
	 */
	public GameBody(Model model) {
		this.model = model;
		gameCycle = new GameLifeCycle();
	}
	
	/**
	 * ���������� ������ �� ������� ������� ����
	 * @see Model
	 * @see GameLifeCycle
	 */
	public void prepare() throws Exception {
		gameCycle.prepare(model);
		model.prepare();
		LOG.info("Model sex is " + model.getSex() + " was born");
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
	 * @see GameLifeCycle
	 */
	public void update(Game game) {
		model.update(game.getTime());
		
		if (!gameCycle.isAlive(model)) {
			game.stop();
			return;
		}
	}
}
