package domain;

import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = 48L;
	private String dept;
	private Set<Employee> employees = new HashSet<Employee>();
	private Set<CheckBack> checks = new HashSet<CheckBack>();

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String dept, Set<Employee> employees, Set<CheckBack> checks) {
		super();
		this.dept = dept;
		this.employees = employees;
		this.checks = checks;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<CheckBack> getChecks() {
		return checks;
	}

	public void setChecks(Set<CheckBack> checks) {
		this.checks = checks;
	}

}
