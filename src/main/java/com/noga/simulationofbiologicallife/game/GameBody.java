package com.noga.simulationofbiologicallife.game;

import java.util.Set;
import java.util.HashSet;

import com.noga.simulationofbiologicallife.core.SystemFactory;
import com.noga.simulationofbiologicallife.core.ModelSystem;
import com.noga.simulationofbiologicallife.core.TimeConverter;

/**
 * Тело игры, которое слушает наблюдаемого {@link Game} и в случае
 * обновления данных, рассылает время жизни модели подписчикам.
 * @author NOGA
 * @version 1.0
 * @see Game
 * @see GameTimeConverter
 * @see ModelSystem
 */
public class GameBody {
	/** Коллекция систем */
	private Set<ModelSystem> systems = new HashSet<ModelSystem>();
	private SystemFactory systemFactory;;
	
	/**
	 * Конструктор
	 * @param systemFactory Ссылка на фабрику систем модели
	 */
	public GameBody(SystemFactory systemFactory) {
		this.systemFactory = systemFactory;
	}
	
	/**
	 * Итерация обновления данных всех систем модели
	 * @param game Текущая игра
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
	 * Добавить новую систему
	 * @param system Система
	 * @return Результат добавления в коллекцию {@link java.util.HashSet}
	 */
	@Deprecated
	public boolean addSystem(ModelSystem system) {
		return systems.add(system);
	}
}
