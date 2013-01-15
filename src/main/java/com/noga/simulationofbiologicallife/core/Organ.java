package com.noga.simulationofbiologicallife.core;

/**
 * ����� (��.-����. � �����������) � ������������ ������������ ��������� 
 * ����� ������ � ������, ����������� ����������� ������� � ����� ���������. 
 * 
 * @author NOGA
 * @version 1.0
 */
public class Organ {
	/** ������������ ������ */
	private String name;
	
	/**
	 * �������������� ���� {@link Organ#name}
	 * 
	 * @see Organ
	 * @param name ������������ ������
	 */
	public Organ(String name) {
		this.name = name;
	}
	
	/**
	 * ������ ������������ ������ {@link Organ#name}
	 * 
	 * @see Organ
	 * @return ������������ ������
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
