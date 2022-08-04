package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.dao.EmployeeRepository;
import org.example.model.Employee;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service(value = "employeeService")
@AllArgsConstructor
public class EmployeeServiceRepository implements EmployeeService{
	private final EmployeeRepository employeeRepository;
	@Override
	public void createEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		employeeRepository.createEmployee(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployees();
	}
	
	@Override
	public void updateEmployeeById(int employeeId) throws SQLException {
		employeeRepository.updateEmployeeById(employeeId);
	}
	
	@Override
	public void deleteEmployeeById(int employeeId) throws SQLException {
		employeeRepository.deleteEmployeeById(employeeId);
		
	}
}
