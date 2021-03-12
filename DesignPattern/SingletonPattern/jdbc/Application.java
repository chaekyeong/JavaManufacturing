package com.jdbc;

import java.sql.SQLException;
import java.util.List;

public class Application {
	public static void main(String[] args) throws SQLException {

		Employee emp = new Employee();
		emp.setEmp_name("Haider");
		emp.setEmp_address("Mars");
		EmployeeDaoImplementation empDao = new EmployeeDaoImplementation();

		// add
		empDao.insert(emp);

		// read
		Employee e = empDao.getEmployee(1);
		System.out.println(e.getEmp_id() + " " + e.getEmp_name() + " " + e.getEmp_address());

		// read All
		List<Employee> ls = empDao.getEmployees();
		for (Employee allEmp : ls) {
			System.out.println(allEmp);
		}

		// update
		Employee tempEmployee = empDao.getEmployee(1);
		tempEmployee.setEmp_address("Asgard");
		empDao.update(tempEmployee);

		// delete
		// empDao.delete(1);
	}
}




