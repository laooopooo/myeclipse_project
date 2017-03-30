package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ���ǵڶ���д���ϵĹ�����ϵͳ����һ���������ϴ��벻ȫ�浼���˺ܶ���󣬿���Դ�������һЩ���󣬸���Դ����дһ��
 * 
 * @author pfjia
 * @date 2017.3.19
 */
public class Employee implements Serializable {
	/**
	 * ����֪������ʲô��
	 */
	private static final long serialVersionUID = -1597227573995993115L;
	// Ա����ʶ
	private Integer id;
	// Ա�������������ظ���
	private String name;
	// ����
	// ���������ظ����ڵ�¼��ʹ�ù��ź������¼
	private String jobNum;

	// Ա������
	private String pass;
	// Ա��ÿ�µ�нˮ
	private double salary;
	// Ա�����ڲ��ŵľ���
	private Manager manager;
	// Ա����Ӧ�Ŀ���
	private Set<Attend> attends = new HashSet<Attend>();
	// Ա����Ӧ�Ĺ��ʼ�¼
	private Set<Payment> payments = new HashSet<Payment>();

	public Employee() {
		// TODO Auto-generated constructor stub
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
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
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

	public Employee(Integer id, String jobNum, String name, String pass,
			double salary, Manager manager, Set<Attend> attends,
			Set<Payment> payments) {

		this.id = id;
		this.setJobNum(jobNum);
		this.name = name;
		this.pass = pass;
		this.salary = salary;
		this.manager = manager;
		this.attends = attends;
		this.payments = payments;
	}

	// id��name����pass����Ȳ������
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}

	public String getJobNum() {
		return jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

}
