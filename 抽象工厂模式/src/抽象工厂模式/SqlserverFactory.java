package ���󹤳�ģʽ;

public class SqlserverFactory implements IFactory {

	@Override
	public DAO createDAO() {
		// TODO Auto-generated method stub
		return new SqlserverDAO();
	}
}
