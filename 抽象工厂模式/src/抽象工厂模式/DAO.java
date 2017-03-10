package 抽象工厂模式;

public interface DAO {
	void insert(User user);

	User query(int id);

}
