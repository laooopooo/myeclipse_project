package dao;

import java.util.List;

import domain.Attend;

public interface AttendDao {
	Integer save(Attend attend);

	void delete(Attend attend);

	void update(Attend attend);

	Attend get(Integer id);

	List<Attend> findAll();
}
