package domain;

import java.io.Serializable;

public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3613055087196458174L;

	// ��ʶ����
	private Integer id;
	// ��н�·�
	private String payMonth;
	// ��н����
	private double amount;
	// ��нԱ��
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
