package dao;

import java.util.List;

import domain.Manager;

/**
 * 面向DAO接口编程，当更换数据库时不用更改上层代码
 * 
 * @author pfjia
 *
 */
public interface ManagerDao {

	Integer save(Manager manager);

	void delete(Manager manager);

	void update(Manager manager);

	Manager get(Integer id);

	List<Manager> findAll();

	boolean hasManager(Manager manager);

	boolean findByNameAndPass(Manager manager);

}
