package dao;

import java.util.List;

import domain.Manager;

/**
 * ����DAO�ӿڱ�̣����������ݿ�ʱ���ø����ϲ����
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
