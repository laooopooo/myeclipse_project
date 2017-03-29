package dao.impl;

import java.util.List;

import support.YeekuHibernateDaoSupport;
import dao.PaymentDao;
import domain.Payment;

public class PaymentDaoHibernate extends YeekuHibernateDaoSupport implements
		PaymentDao {

	@Override
	public Integer save(Payment payment) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().save(payment);
	}

	@Override
	public void delete(Payment payment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(payment);
	}

	@Override
	public void update(Payment payment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(payment);
	}

	@Override
	public Payment get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Payment.class, id);
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Payment");
	}

}
