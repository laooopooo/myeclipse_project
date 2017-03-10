package 抽象工厂模式;

public class SqlserverFactory implements IFactory {

	@Override
	public DAO createDAO() {
		// TODO Auto-generated method stub
		return new SqlserverDAO();
	}
}
