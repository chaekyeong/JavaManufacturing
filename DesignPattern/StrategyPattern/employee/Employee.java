package com.employee;

public abstract class Employee {
	ComputingSkills cs;
	Proficency proficency;
	
	public Employee() {

	}
	
	public void setCs(ComputingSkills cs) {
		this.cs = cs;
	}

	public void setProficency(Proficency proficency) {
		this.proficency = proficency;
	}


	public abstract void introduceDepartment();
	
	public void introduceCs() {
		cs.skills();
	}
	
	public void introduceProficency() {
		proficency.career();
	}
}
