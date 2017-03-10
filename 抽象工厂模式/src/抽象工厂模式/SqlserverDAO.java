package 抽象工厂模式;

public class SqlserverDAO implements DAO {

	@Override
	public User query(int id) {
		// TODO Auto-generated method stub
		System.out.println("根据id得到User");
		return null;
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		System.out.println("insert 一条数据");
	}
}
