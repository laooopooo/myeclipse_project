package domain;

import java.io.Serializable;

public class AttendType implements Serializable {
	private Integer id;
	private String name;
	private double amerce;

	public AttendType() {
		// TODO Auto-generated constructor stub
	}

	public AttendType(Integer id, String name, double amerce) {
		super();
		this.id = id;
		this.name = name;
		this.amerce = amerce;
	}

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

	public double getAmerce() {
		return amerce;
	}

	public void setAmerce(double amerce) {
		this.amerce = amerce;
	}

}
