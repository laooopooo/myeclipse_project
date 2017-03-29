package dao;

import java.util.List;

import domain.CheckBack;

public interface CheckBackDao {

	Integer save(CheckBack check);

	void delete(CheckBack check);

	void update(CheckBack check);

	CheckBack get(Integer id);

	List<CheckBack> findAll();

}
