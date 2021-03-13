package com.jdbc;

import java.sql.SQLException;
import java.util.List;

public class Application {
	public static void main(String[] args) throws SQLException {
		Employee emp = new Employee("chaekyeong", "Seoul");
		emp.setEmp_name("chaekyeong6");
		emp.setEmp_address("Hawai");
		EmployeeDaoImplementation empDao = new EmployeeDaoImplementation();

		// add
		int addNum = empDao.insert(emp);
		System.out.println(addNum + "개 추가");

		// read
		Employee e = empDao.getEmployee(21);
		System.out.println(e.getEmp_id() + " " + e.getEmp_name() + " " + e.getEmp_address());
		
		// read All
		List<Employee> employees = empDao.getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		// update
		Employee tmpEmployee = empDao.getEmployee(21);
		tmpEmployee.setEmp_address("NewYork");
		int updNum = empDao.update(tmpEmployee);
		System.out.println(updNum + "개 행 업데이트");
		
		// delete
		int delNum = empDao.delete(1);
		System.out.println(delNum + "개 행 삭제");
	}
}




