package dao;

import java.util.List;

import domain.Application;

public interface ApplicationDao {
	Integer save(Application payment);

	void delete(Application payment);

	void update(Application payment);

	Application get(Integer id);

	List<Application> findAll();
}
