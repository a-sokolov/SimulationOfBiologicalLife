package com.noga.simulationofbiologicallife.human;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.ModelSystem;
import com.noga.simulationofbiologicallife.core.TimeConverter;

/**
 * ������������ ������� �����
 * @author sbt-sokolov-av
 * @version 1.0
 * @see Model
 */
public class GrowSystem extends ModelSystem {
	/**
	 * �����������
	 * @param model ������
	 * @see Model
	 */
	public GrowSystem(Model model) {
		super(model);
	}
	
	@Override
	public void updateInterval(TimeConverter time) {
		//
	}
	
	/**
	 * ������������ ���������� ������������ ���������� ��������
	 * @author NOGA
	 */
	private enum Periods {
		NEWBORN("�������������")
		, BABY("������� �������")
		, INFANCY("������ �������")
		, FIRST_CHILDHOOD("������ �������")
		, SECOND_CHILDHOOD("������ �������")
		, TEENS("������������ �������")
		, ADOLESCENCE("��������� �������")
		, FIRST_ADULTHOOD("������ ������� (1-� ������)")
		, SECOND_ADULHOOD("������ ������� (2-� ������)")
		, ADVANCED_AGE("������� �������")
		, SENIUM("���������� �������")
		, LONG_LIVER("�����������");
		
		private String description;
		private int daysFrom;
		private int daysTo;
		
		private Periods(String description) {
			this(description, 0, 0);
		}
		
		private Periods(String description, int daysFrom, int daysTo) {
			this.description = description;
			this.daysFrom = daysFrom;
			this.daysTo = daysTo;
		}
		
		public String getDescription() {
			return description;
		}
	}
}
