package dao.impl;

import java.util.List;

import support.YeekuHibernateDaoSupport;
import dao.ApplicationDao;
import domain.Application;

public class ApplicationDaoHibernate extends YeekuHibernateDaoSupport implements
		ApplicationDao {
	@Override
	public Integer save(Application attend) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(attend);
	}

	@Override
	public void delete(Application attend) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(attend);
	}

	@Override
	public void update(Application attend) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(attend);
	}

	@Override
	public Application get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Application.class, id);
	}

	@Override
	public List<Application> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Attend");
	}
}
