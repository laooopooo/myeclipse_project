package domain;

import java.io.Serializable;
import java.util.Date;

public class Attend implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5935792977935812014L;

	// ��ʶ����
	private Integer id;
	// ������
	private String dutyDay;
	// ��ʱ��
	private Date punchTime;
	// �����ϰ�򿨺��°�򿨣��ж��Ƿ����ϰ��
	private boolean isCome;
	// ��������
	private AttendType type;
	// ���ڵ�Ա��
	private Employee employee;

	public Attend() {
		// TODO Auto-generated constructor stub
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

	public Attend(Integer id, String dutyDay, Date punchTime, boolean isCome,
			AttendType type, Employee employee) {
		super();
		this.id = id;
		this.dutyDay = dutyDay;
		this.punchTime = punchTime;
		this.isCome = isCome;
		this.type = type;
		this.employee = employee;
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

	public AttendType getType() {
		return type;
	}

	public void setType(AttendType type) {
		this.type = type;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
