package com.noga.simulationofbiologicallife.game;

import org.apache.log4j.Logger;

import com.noga.simulationofbiologicallife.core.Model;

/**
 * Тело игры, которое слушает наблюдаемого {@link Game} и в случае
 * обновления данных, рассылает время жизни модели.
 * @author NOGA
 * @version 1.0
 * @see Game
 * @see Model
 */
public class GameBody {
	/** Логгер */
	private static final Logger LOG = Logger.getLogger(GameBody.class);
	
	/** Ссылка на модель {@link Model} */
	private Model model;
	/** Ссылка на жизненный цикл {@link GameLiveCycle} */
	private GameLifeCycle gameCycle;
	
	/**
	 * Конструктор
	 * @param model Ссылка на модель {@link Model}
	 */
	public GameBody(Model model) {
		this.model = model;
		gameCycle = new GameLifeCycle();
	}
	
	/**
	 * Подготовка данных до момента запуска игры
	 * @see Model
	 * @see GameLifeCycle
	 */
	public void prepare() throws Exception {
		gameCycle.prepare(model);
		model.prepare();
		LOG.info("Model sex is " + model.getSex() + " was born");
	}
	
	/**
	 * Закрытие тела игры
	 * @see Model
	 */
	public void close() {
		model.die();
		model.close();
	}
	
	/**
	 * Итерация обновления данных модели
	 * @param game Текущая игра
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
