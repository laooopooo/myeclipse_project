package ���󹤳�ģʽ;

public class Client {
	public static void main(String[] args) {
		User user = new User();
		IFactory factory = new SqlserverFactory();
		DAO sqlaserverUser = factory.createDAO();
		sqlaserverUser.insert(user);
		sqlaserverUser.query(1);
	}
}
