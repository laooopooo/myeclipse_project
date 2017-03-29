package dao.impl;

import java.util.List;

import support.YeekuHibernateDaoSupport;
import dao.AttendDao;
import domain.Attend;

public class AttendDaoHibernate extends YeekuHibernateDaoSupport implements
		AttendDao {

	@Override
	public Integer save(Attend attend) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(attend);
	}

	@Override
	public void delete(Attend attend) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(attend);
	}

	@Override
	public void update(Attend attend) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(attend);
	}

	@Override
	public Attend get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Attend.class, id);
	}

	@Override
	public List<Attend> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Attend");
	}

}
