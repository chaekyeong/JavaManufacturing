package com.employee;

public class Sales extends Employee {
	public Sales() {
		cs = new NonWellComputing();
		proficency = new Sawon();
	}
	@Override
	public void introduceDepartment() {
		System.out.println("Hello~ We are HR Department.");
		
	}


}
