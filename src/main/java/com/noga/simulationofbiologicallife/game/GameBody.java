package com.noga.simulationofbiologicallife.game;

import java.util.Observable;
import java.util.Observer;

/**
 * Тело игры, которое слушает наблюдаемого {@link Game} и в случае
 * обновления данных, рассылает время жизни модели подписчикам.
 * @author NOGA
 * @version 1.0
 * @see Observer
 * @see Game
 */
public class GameBody implements Observer {

	public void update(Observable obs, Object o) {
		if (obs.hasChanged()) {
			if (obs instanceof Game) {
				long currentTime = ((Game) obs).getTime();
			}
		}
	}
}
