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
	 * 根据用户名和密码判断员工数据库中是否有此人
	 * 
	 * @param manager
	 *            虽然是个Manager对象，但其实其中只有 名字和密码有效
	 * @return 查询成功，返回true
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
