package dao.impl;

import java.util.List;

import support.YeekuHibernateDaoSupport;
import dao.EmployeeDao;
import domain.Employee;

public class EmployeeDaoHibernate extends YeekuHibernateDaoSupport implements
		EmployeeDao {

	/**
	 * �� ����id��ȡʵ��
	 */
	@Override
	public Employee get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Employee.class, id);
	}

	/**
	 * ��
	 */
	@Override
	public Integer save(Employee employee) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(employee);
	}

	/**
	 * ��
	 */
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(employee);
	}

	/**
	 * ɾ
	 */
	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(employee);
	}

	/**
	 * ��ѯȫ��ʵ��
	 */
	@Override
	public List<Employee> finadAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Employee");
	}

}
