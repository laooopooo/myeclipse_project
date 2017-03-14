package domain;

import java.io.Serializable;
import java.util.Date;

public class Attend implements Serializable {
	private Integer id;
	private String dutyDay;
	private Date punchTime;
	private boolean isCome;
	private Employee employee;
	private AttendType type;

	public Attend() {
		// TODO Auto-generated constructor stub
	}

	public Attend(Integer id, String dutyDay, Date punchTime, boolean isCome,
			Employee employee, AttendType type) {
		super();
		this.id = id;
		this.dutyDay = dutyDay;
		this.punchTime = punchTime;
		this.isCome = isCome;
		this.employee = employee;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDutyDay() {
		return dutyDay;
	}

	public void setDutyDay(String dutyDay) {
		this.dutyDay = dutyDay;
	}

	public Date getPunchTime() {
		return punchTime;
	}

	public void setPunchTime(Date punchTime) {
		this.punchTime = punchTime;
	}

	public boolean isCome() {
		return isCome;
	}

	public void setCome(boolean isCome) {
		this.isCome = isCome;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public AttendType getType() {
		return type;
	}

	public void setType(AttendType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dutyDay == null) ? 0 : dutyDay.hashCode());
		result = prime * result
				+ ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (isCome ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attend other = (Attend) obj;
		if (dutyDay == null) {
			if (other.dutyDay != null)
				return false;
		} else if (!dutyDay.equals(other.dutyDay))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (isCome != other.isCome)
			return false;
		return true;
	}

}
