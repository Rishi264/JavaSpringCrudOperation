package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Employee;
public interface EmployeeService {
	void createEmployee(Employee employee) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;
	
	void updateEmployeeById(int employeeId) throws SQLException;
	
	void deleteEmployeeById(int employeeId) throws SQLException;
}
