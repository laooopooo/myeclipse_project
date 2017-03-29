package dao.impl;

import java.util.List;

import support.YeekuHibernateDaoSupport;
import dao.EmployeeDao;
import domain.Employee;

public class EmployeeDaoHibernate extends YeekuHibernateDaoSupport implements
		EmployeeDao {

	/**
	 * 查 根据id获取实例
	 */
	@Override
	public Employee get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Employee.class, id);
	}

	/**
	 * 增
	 */
	@Override
	public Integer save(Employee employee) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(employee);
	}

	/**
	 * 改
	 */
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(employee);
	}

	/**
	 * 删
	 */
	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(employee);
	}

	/**
	 * 查询全部实例
	 */
	@Override
	public List<Employee> finadAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Employee");
	}

}
