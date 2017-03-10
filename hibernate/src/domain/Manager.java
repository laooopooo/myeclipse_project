package domain;

import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee {
	private String department;
	private Set<Employee> employees = new HashSet<Employee>();

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
