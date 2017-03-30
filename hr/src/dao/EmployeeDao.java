package dao;

import java.util.List;

import domain.Employee;

public interface EmployeeDao {
	Employee get(Integer id);

	Integer save(Employee employee);

	void update(Employee employee);

	void delete(Employee employee);

	boolean hasEmployee(Employee emp);

	List<Employee> finadAll();
}
