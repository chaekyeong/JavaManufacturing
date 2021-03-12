package com.employee;

public class Hr extends Employee {
	public Hr() {
		cs = new NonWellComputing();
		proficency = new Gwajang();
	}

	@Override
	public void introduceDepartment() {
		System.out.println("Hello~ We are HR Department.");
		
	}
}
