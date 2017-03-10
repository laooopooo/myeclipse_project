package dao;

import java.util.List;

import domain.Employee;
import domain.Manager;

public interface EmployeeDao {
	Employee get(Integer id);

	Integer save(Employee employee);

	void update(Employee employee);

	void delete(Employee employee);

	void delete(Integer id);

	List<Employee> findAll();

	Employee findByNameAndPass(Employee employee);

	Employee findByName(String name);

	List<Employee> findByManager(Manager manager);
}
