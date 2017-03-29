package dao;

import java.util.List;

import domain.Payment;

public interface PaymentDao {

	Integer save(Payment payment);

	void delete(Payment payment);

	void update(Payment payment);

	Payment get(Integer id);

	List<Payment> findAll();
}
