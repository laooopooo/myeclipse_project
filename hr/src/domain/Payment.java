package domain;

import java.io.Serializable;

public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3613055087196458174L;

	// 标识属性
	private Integer id;
	// 发薪月份
	private String payMonth;
	// 发薪数量
	private double amount;
	// 领薪员工
	private Employee employee;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Integer id, String payMonth, double amount, Employee employee) {
		super();
		this.id = id;
		this.payMonth = payMonth;
		this.amount = amount;
		this.employee = employee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
