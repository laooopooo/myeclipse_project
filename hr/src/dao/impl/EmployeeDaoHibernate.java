package dao.impl;

import java.util.List;

import dao.EmployeeDao;
import domain.Employee;

public class EmployeeDaoHibernate extends Yeeku implements EmployeeDao {

	/**
	 * 根据id获取实例
	 */
	@Override
	public Employee get(Integer id) {
		// TODO Auto-generated method stub
		return get;
	}

	@Override
	public Integer save(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> finadAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
