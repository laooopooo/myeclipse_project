package dao;

import java.util.List;

import domain.CheckBack;

public interface CheckBackDao {
	CheckBack get(Integer id);

	Integer save(CheckBack checkBack);

	void update(CheckBack checkBack);

	void delete(CheckBack checkBack);

	void delete(Integer id);

	List<CheckBack> findAll();

}
