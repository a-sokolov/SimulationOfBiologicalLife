package com.noga.simulationofbiologicallife.game;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.TimeConverter;

/**
 * Тело игры, которое слушает наблюдаемого {@link Game} и в случае
 * обновления данных, рассылает время жизни модели.
 * @author NOGA
 * @version 1.0
 * @see Game
 * @see GameTimeConverter
 * @see Model
 */
public class GameBody {
	private Model model;
	
	/**
	 * Конструктор
	 * @param model Ссылка на модель {@link Model}
	 */
	public GameBody(Model model) {
		this.model = model;
	}
	
	/**
	 * Итерация обновления данных модели
	 * @param game Текущая игра
	 * @see TimeConverter
	 * @see Model
	 */
	public void update(Game game) {
		TimeConverter time = new TimeConverter(game.getTime());
		model.update(time);
	}
}
