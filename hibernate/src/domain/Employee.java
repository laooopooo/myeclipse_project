package domain;

import java.util.HashSet;
import java.util.Set;

public class Employee extends Person {
	private String title;
	private double salary;
	private Set<Customer> customers = new HashSet<Customer>();
	private Manager manager;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String title, double salary) {
		this.title = title;
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
