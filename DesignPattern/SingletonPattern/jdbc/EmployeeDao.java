package com.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

	public int insert(Employee emp) throws SQLException;

	public int delete(int id) throws SQLException;
	
	public int update(Employee emp) throws SQLException;

	public Employee getEmployee(int id) throws SQLException;

	public List<Employee> getEmployees() throws SQLException;

	
}
