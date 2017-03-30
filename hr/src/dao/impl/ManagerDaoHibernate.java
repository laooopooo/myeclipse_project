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

	/**
	 * 
	 * �����û����������ж�Ա�����ݿ����Ƿ��д���
	 * 
	 * @param manager
	 *            ��Ȼ�Ǹ�Manager���󣬵���ʵ����ֻ�� ���ֺ�������Ч
	 * @return ��ѯ�ɹ�������true
	 */
	@Override
	public boolean hasManager(Manager manager) {
		List result = getHibernateTemplate().find(
				"from Employee p where p.jobNum= ? and p.pass= ?",
				manager.getJobNum(), manager.getPass());
		if (result.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean findByNameAndPass(Manager manager) {
		// TODO Auto-generated method stub
		return false;
	}

}
