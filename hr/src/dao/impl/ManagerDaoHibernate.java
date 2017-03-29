package dao.impl;

import java.util.List;

import support.YeekuHibernateDaoSupport;
import dao.ManagerDao;
import domain.Manager;

public class ManagerDaoHibernate extends YeekuHibernateDaoSupport implements
		ManagerDao {

	@Override
	public Integer save(Manager manager) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(manager);
	}

	@Override
	public void delete(Manager manager) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(manager);
	}

	@Override
	public void update(Manager manager) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(manager);
	}

	@Override
	public Manager get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Manager.class, id);
	}

	@Override
	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Manager");
	}

}
