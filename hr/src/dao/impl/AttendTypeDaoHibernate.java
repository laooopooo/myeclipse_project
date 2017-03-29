package dao.impl;

import java.util.List;

import support.YeekuHibernateDaoSupport;
import dao.AttendTypeDao;
import domain.AttendType;

public class AttendTypeDaoHibernate extends YeekuHibernateDaoSupport implements
		AttendTypeDao {

	@Override
	public Integer save(AttendType type) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(type);
	}

	@Override
	public void delete(AttendType type) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(type);
	}

	@Override
	public void update(AttendType type) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(type);
	}

	@Override
	public AttendType get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(AttendType.class, id);
	}

	@Override
	public List<AttendType> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from AttendType");
	}

}
