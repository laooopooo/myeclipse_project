package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author pfjia
 * @date 2017.3.19
 */
public class Manager extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1601611970296520863L;
	// 该经理管理的部门
	private String dept;
	// 经理所在部门的员工
	private Set<Employee> employees = new HashSet<Employee>();
	// 经理签署的所有批复
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
