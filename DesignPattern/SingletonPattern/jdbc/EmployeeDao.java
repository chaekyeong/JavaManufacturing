package com.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

	public int insert(Employee emp) throws SQLException;

	public void delete(int id) throws SQLException;
	
	public void update(Employee emp) throws SQLException;

	public Employee getEmployee(int id) throws SQLException;

	public List<Employee> getEmployees() throws SQLException;

	
}
