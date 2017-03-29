package dao.impl;

import java.util.List;

import support.YeekuHibernateDaoSupport;
import dao.CheckBackDao;
import domain.CheckBack;

public class CheckBackDaoHibernate extends YeekuHibernateDaoSupport implements
		CheckBackDao {

	@Override
	public Integer save(CheckBack check) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(check);
	}

	@Override
	public void delete(CheckBack check) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(check);
	}

	@Override
	public void update(CheckBack check) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(check);
	}

	@Override
	public CheckBack get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CheckBack.class, id);
	}

	@Override
	public List<CheckBack> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from CheckBack");
	}

}
