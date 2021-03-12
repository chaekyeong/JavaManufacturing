package com.employee;

public class It extends Employee {
	public It() {
		cs = new WellComputing();
		proficency = new Daeli();
	}
	@Override
	public void introduceDepartment() {
		System.out.println("Hello! We are responsible for software.");
		
	}


}
