package org.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Employee;

public interface EmployeeRepository {
	void createEmployee(Employee employee) throws SQLException;
	
	List<Employee> getAllEmployees() throws SQLException;
	
	void insertEmployees(String first_name,String last_name,String email) throws SQLException;
	
	void updateEmployeeById(int employeeId) throws SQLException;
	
	void deleteEmployeeById(int employeeId) throws SQLException;
}
