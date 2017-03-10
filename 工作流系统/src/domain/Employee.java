package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Employee implements Serializable {
	private static final long serialVersionUID = 48L;

	private Integer id;
	private String name;
	private String pass;
	private double salary;
	private Manager Manager;
	private Set<Attend> attends = new HashSet<Attend>();
	private Set<Payment> payments = new HashSet<Payment>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Manager getManager() {
		return Manager;
	}

	public void setManager(Manager manager) {
		Manager = manager;
	}

	public Set<Attend> getAttends() {
		return attends;
	}

	public void setAttends(Set<Attend> attends) {
		this.attends = attends;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee() {

	}

}
