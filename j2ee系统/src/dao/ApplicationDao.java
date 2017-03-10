package dao;

import java.util.List;

import domain.Application;
import domain.Employee;

public interface ApplicationDao {
	Application get(Integer id);

	Integer save(Application application);

	void update(Application application);

	void delete(Application application);

	void delete(Integer id);

	List<Application> findAll();

	List<Application> findByEmp(Employee emp);
}
