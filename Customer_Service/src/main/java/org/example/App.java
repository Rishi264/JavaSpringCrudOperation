package org.example;

/**
 * Hello world!
 *
 */

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import javax.sql.DataSource;
import org.example.config.SpringConfig;
import org.example.dao.EmployeeRepository;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App 
{

    private static ApplicationContext context;
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {
        	context = new AnnotationConfigApplicationContext(SpringConfig.class);
			Scanner scanner = context.getBean("scanner", Scanner.class);
			EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
			int choice = 0;
			String firstName, lastName, email = null;
			List<Employee> employees = null;
			do {
				System.out.println("1. Create Employee. ");
				System.out.println("2. Fetch All Employees. ");
				System.out.println("3. Updation. ");
				System.out.println("4 Deletion. ");
				System.out.println("0. Exit. ");
				System.out.print("Enter your choice: ");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.print("First Name: ");
					firstName = scanner.next();
					System.out.print("Last Name: ");
					lastName = scanner.next();
					System.out.print("Email: ");
					email = scanner.next();
					employeeService.createEmployee(new Employee(firstName, lastName, email));
					break;
				case 2:
					employees = employeeService.getAllEmployees();
					for(Employee e:employees)
					{
						System.out.println(e);
					}
					
					break;
				case 3:
					System.out.println("Enter the id");
					employeeService.updateEmployeeById(scanner.nextInt());
					break;
				case 4:
					System.out.println("Enter the id");
					employeeService.deleteEmployeeById(scanner.nextInt());
					break;
				case 0:
					System.out.println("Bye...!");
					System.exit(0);
					break;
				default:
					System.out.println("invalid choice try again...");
					break;
				}

			} while (choice != 0);
        	/*
        	context = new AnnotationConfigApplicationContext(SpringConfig.class);
        
        	EmployeeRepository employeeRepository=context.getBean("employeeRepository",EmployeeRepository.class);
        	Scanner scanner=context.getBean("scanner",Scanner.class);
        	System.out.print("First Name: ");
			String fName=scanner.next();
			System.out.print("Last Name: ");
			String lName=scanner.next();
			System.out.print("Email: ");
			String eml=scanner.next();
			Employee tempEmployee= employeeRepository.createEmployee(new Employee(fName, lName, eml));
        	List<Employee> employees=employeeRepository.getAllEmployees();
        	for(Employee employee:employees)
        	{
        		System.out.println(employee);
        	}
			*/
		} 
        catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
