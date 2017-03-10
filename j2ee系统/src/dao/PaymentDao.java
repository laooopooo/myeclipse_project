package dao;

import java.util.List;

import domain.Employee;
import domain.Payment;

public interface PaymentDao {
	Payment get(Integer id);

	Integer save(Payment payment);

	void update(Payment payment);

	void delete(Payment payment);

	void delete(Integer id);

	List<Payment> findAll();

	List<Payment> findByEmp(Employee employee);

	Payment findByMonthAndEmp(String payMonth, Employee emp);
}
