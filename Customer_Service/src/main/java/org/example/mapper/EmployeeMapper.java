package org.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.model.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt(1));
		employee.setFirstName(rs.getString(2));
		employee.setLastName(rs.getString(3));
		employee.setEmail(rs.getString(4));
		return employee;
	}

}

