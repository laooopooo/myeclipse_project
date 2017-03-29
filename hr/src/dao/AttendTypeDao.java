package dao;

import java.util.List;

import domain.AttendType;

public interface AttendTypeDao {

	Integer save(AttendType type);

	void delete(AttendType type);

	void update(AttendType type);

	AttendType get(Integer id);

	List<AttendType> findAll();

}
