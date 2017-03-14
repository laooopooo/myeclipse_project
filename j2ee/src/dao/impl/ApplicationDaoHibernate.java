package dao.impl;

import java.util.List;

import support.YeekuHibernateDaoSupport;
import dao.ApplicationDao;
import domain.Application;
import domain.Employee;

public class ApplicationDaoHibernate extends YeekuHibernateDaoSupport implements
		ApplicationDao {

	@Override
	public Application get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Application.class, id);
	}

	@Override
	public Integer save(Application application) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(application);
	}

	@Override
	public void update(Application application) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(application);
	}

	@Override
	public void delete(Application application) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(application);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Application> findAll() {
		// TODO Auto-generated method stub
		return (List<Application>) getHibernateTemplate().find(
				"from Application");
	}

	@Override
	public List<Application> findByEmp(Employee emp) {
		// TODO Auto-generated method stub
		return (List<Application>) getHibernateTemplate().find(
				"from Application as a where a.attend.employee=?", emp);
	}

}
