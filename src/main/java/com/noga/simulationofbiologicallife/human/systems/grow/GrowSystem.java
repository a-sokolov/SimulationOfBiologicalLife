package com.noga.simulationofbiologicallife.human.systems.grow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.noga.simulationofbiologicallife.core.Model;
import com.noga.simulationofbiologicallife.core.ModelSystem;
import com.noga.simulationofbiologicallife.core.TimeConverter;
import com.noga.simulationofbiologicallife.core.Sex;
import com.noga.simulationofbiologicallife.core.TimeInterval;

import static com.noga.simulationofbiologicallife.core.TimeInterval.*;

/**
 * ������������ ������� �����
 * @author sbt-sokolov-av
 * @version 1.0
 * @see Model
 */
public class GrowSystem extends ModelSystem {
	private static final String OUTPUT = "%s (� %d �� %d)"; 
	
	private List<AgePeriods> periods = new ArrayList<AgePeriods>(AgePeriods.values().length);
	
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
		Sex sex = this.getModel().getSex();
		long minutes = time.getTime(TimeInterval.MINUTE);

		for(AgePeriods agePeriod : AgePeriods.values()) {
			Period period = agePeriod.getPeriod(sex);
			
			if (minutes >= period.getDaysFrom() && minutes <= period.getDaysTo()) {
				if (!periods.contains(agePeriod)) {
					System.out.println(String.format(OUTPUT, agePeriod.getDescription()
														   , period.getDaysFrom()
														   , period.getDaysTo()));
					periods.add(agePeriod);
				}
				return;
			}
		}
	}
	
	/**
	 * ������������ ���������� ������������ ���������� ��������
	 * @author NOGA
	 */
	private enum AgePeriods {
		NEWBORN("�������������", new Period(1, 10))
		, BABY("������� �������", new Period(10, YEAR.getMinutes()))
		, INFANCY("������ �������", new Period(YEAR.getMinutes(), YEAR.getMinutes() * 3))
		, FIRST_CHILDHOOD("������ �������", new Period(YEAR.getMinutes() * 4, YEAR.getMinutes() * 7))
		, SECOND_CHILDHOOD("������ �������", new Period(YEAR.getMinutes() * 8, YEAR.getMinutes() * 12)
										   , new Period(YEAR.getMinutes() * 8, YEAR.getMinutes() * 11))
		, TEENS("������������ �������", new Period(YEAR.getMinutes() * 13, YEAR.getMinutes() * 16)
							          , new Period(YEAR.getMinutes() * 12, YEAR.getMinutes() * 15))
		, ADOLESCENCE("��������� �������", new Period(YEAR.getMinutes() * 17, YEAR.getMinutes() * 21)
								    	 , new Period(YEAR.getMinutes() * 16, YEAR.getMinutes() * 20))
		, FIRST_ADULTHOOD("������ ������� (1-� ������)", new Period(YEAR.getMinutes() * 22, YEAR.getMinutes() * 35)
													   , new Period(YEAR.getMinutes() * 21, YEAR.getMinutes() * 35))
		, SECOND_ADULHOOD("������ ������� (2-� ������)", new Period(YEAR.getMinutes() * 36, YEAR.getMinutes() * 60)
													   , new Period(YEAR.getMinutes() * 36, YEAR.getMinutes() * 55))
		, ADVANCED_AGE("������� �������", new Period(YEAR.getMinutes() * 61, YEAR.getMinutes() * 74)
									    , new Period(YEAR.getMinutes() * 56, YEAR.getMinutes() * 74))
		, SENIUM("���������� �������", new Period(YEAR.getMinutes() * 75, YEAR.getMinutes() * 90))
		, LONG_LIVER("�����������", new Period(YEAR.getMinutes() * 90, YEAR.getMinutes() * 122));
		 
		/** �������� �������  */
		private String description;
		/**
		 * ���� �������
		 * @see Period
		 * @see Sex
		 */
		private Map<Sex, Period> periods = new HashMap<Sex, Period>();
		
		/**
		 * �����������
		 * @param description �������� 
		 * @param unisexPeriod �������� ������� "�������"
		 */
		private AgePeriods(String description, Period unisexPeriod) {
			this.description = description;
			this.periods.put(Sex.UNISEX, unisexPeriod);
		}
		
		/**
		 * �����������
		 * @param description ��������
		 * @param manPeriod �������� ������� "�������"
		 * @param womanPeriod �������� ������� "�������"
		 * @see Period
		 * @see Sex
		 */
		private AgePeriods(String description, Period manPeriod, Period womanPeriod) {
			this.description = description;
			this.periods.put(Sex.MAN, manPeriod);
			this.periods.put(Sex.WOMAN, womanPeriod);
		}
		
		/**
		 * ������ �������� �������
		 * @param sex ��� ��������
		 * @return ������ �� �������� �������
		 * @see Period
		 * @see Sex
		 */
		public Period getPeriod(Sex sex) {
			if (periods.containsKey(sex)) {
				return periods.get(sex);
			} else {
				return periods.get(Sex.UNISEX);
			}
		}
		
		/**
		 * ������ ��������
		 * @return �������� �������
		 */
		public String getDescription() {
			return description;  
		}
	}
}
