package dao;

import java.util.List;

import domain.AttendType;

public interface AttendTypeDao {
	AttendType get(Integer id);

	Integer save(AttendType attendType);

	void update(AttendType attendType);

	void delete(AttendType attendType);

	void delete(Integer id);

	List<AttendType> findAll();
}
