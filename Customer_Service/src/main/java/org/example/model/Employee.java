package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	@Override
	public String toString() {
		return "\nEmployee ID: "+getId()+"\nFirst Name: "+getFirstName()+"\nLast Name: "+getLastName()+
				"\nEmail: "+getEmail();
	}
	
	
	
	
	
}
