package org.example.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.example.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository(value="employeeRepository")
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository{

	private final JdbcTemplate jdbcTemplate;
	private Scanner scanner;

	//private Connection connection = null;
	//private Statement statement = null;
	//private ResultSet resultSet = null;
	//private PreparedStatement preparedStatement=null;
	// private PreparedStatement preparedStatement=null;

	@Override
	public void createEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		
		jdbcTemplate.update("insert into employees(first_name,last_name,email) values(?,?,?)", employee.getFirstName(),
				employee.getLastName(), employee.getEmail());
		/*preparedStatement=connection.prepareStatement("insert into employees(first_name,last_name,email) values(?,?,?)");
		preparedStatement.setString(1, employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.setString(3, employee.getEmail());
		preparedStatement.executeUpdate();
		return employee;
		*/
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> list = jdbcTemplate.query("select * from employees", new RowMapper<Employee>() {
				  
				  @Override 
				  public Employee mapRow(ResultSet rs, int rowNum) throws SQLException { 
				  // TODO Auto-generated method stub 
			      Employee employee = new Employee(); 
			      employee.setId(rs.getInt(1));
				  employee.setFirstName(rs.getString(2));
				  employee.setLastName(rs.getString(3)); employee.setEmail(rs.getString(4));
				  return employee; }
				  
				  });
		return list;
		/*statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from employees");
		List<Employee> employees = new ArrayList<Employee>();
		while (resultSet.next()) {
			employees.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4)));
		}
		return employees;*/
	}
	
	
	@Override
	public void updateEmployeeById(int employeeId) throws SQLException {

		List<Employee> list = getAllEmployees();
		boolean flag = false;
		for (Employee e : list) {
			if (e.getId() == employeeId) {
				flag = true;
				break;
			}
		}

		// Employee employee= jdbcTemplate.queryForObject("select * from employees where
		// id="+employeeId,new EmployeeMapper());

		// if(employee==null)

		if (flag == false) {
			System.out.println("no such id found...");
		} else {
			System.out.print("Enter New First Name: ");
			String fName = scanner.next();
			System.out.print("Enter New Last Name: ");
			String lName = scanner.next();
			System.out.print("Enter New Email: ");
			String email = scanner.next();

			int count = jdbcTemplate.update("update employees set first_name=?,last_name=?,email=? where id=?", fName,
					lName, email, employeeId);
			System.out.println("updation successfull.." + count + " record updated...!");
		}

	}
	
	@Override
	public void deleteEmployeeById(int employeeId) throws SQLException {

		List<Employee> list = getAllEmployees();
		boolean flag = false;
		for (Employee e : list) {
			if (e.getId() == employeeId) {
				flag = true;
				break;
			}
		}

		// Employee employee= jdbcTemplate.queryForObject("select * from employees where
		// id="+employeeId,new EmployeeMapper());

		// if(employee==null)

		if (flag == false) {
			System.out.println("no such id found...");
		} else {
			
			int count = jdbcTemplate.update("delete from employees where id=?", employeeId);
			System.out.println("deletion successfull.." + count + " record updated...!");
		}
	}

	@Override
	public void insertEmployees(String first_name,String last_name,String email) throws SQLException{
		//statement =connection.createStatement();
		 //statement.execute("INSERT INTO EMPLOYEES (FIRST_NAME,LAST_NAME,email) "
	       //         + "VALUES (first_name,last_name,email)");
	}
/*
	public EmployeeRepositoryImpl(DataSource dataSource) throws SQLException {

		this.dataSource = dataSource;
		connection = dataSource.getConnection();
	}*/
}
