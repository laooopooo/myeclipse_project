package domain;

import java.io.Serializable;

public class Payment implements Serializable {
	private Integer id;
	private String payMonth;
	private Double amount;
	private Employee employee;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Integer id, String payMonth, Double amount, Employee employee) {
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
