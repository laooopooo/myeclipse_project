package support;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class YeekuHibernateDaoSupport extends HibernateDaoSupport {

	/**
	 * 使用hql语句进行分页查询
	 * 
	 * @param hql
	 * @param offset
	 *            第一条记录索引
	 * @param pageSize
	 * @return 当前页的所有记录
	 */
	public List findByPage(final String hql, final int offset,
			final int pageSize) {
		List list = getHibernateTemplate().executeFind(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						List result = session.createQuery(hql)
								.setFirstResult(offset).setMaxResults(pageSize)
								.list();
						return result;
					}
				});

		return list;
	}

	/**
	 * 
	 * @param hql
	 * @param value
	 *            传入hql语句的参数
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List findByPage(final String hql, final Object value,
			final int offset, final int pageSize) {
		List list = getHibernateTemplate().executeFind(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						List result = session.createQuery(hql)
								.setParameter(0, value).setFirstResult(offset)
								.setMaxResults(pageSize).list();
						return result;
					}
				});

		return list;
	}

	/**
	 * 
	 * @param hql
	 * @param values
	 *            hql语句中的多个参数
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize) {

		List list = getHibernateTemplate().executeFind(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub

						Query query = session.createQuery(hql);
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
						List result = query.setFirstResult(offset)
								.setMaxResults(pageSize).list();
						return result;
					}
				});

		return list;

	}

}
