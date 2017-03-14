package dao;

import java.util.List;

import domain.Manager;

public interface ManagerDao {
	Manager get(Integer id);

	String save(Manager manager);

	void update(Manager manager);

	void delete(Manager manager);

	void delete(Integer id);

	List<Manager> findAll();

	List<Manager> findByNameAndPass(Manager manager);

	Manager findByName(String name);
}
