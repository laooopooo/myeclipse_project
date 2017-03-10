package proxy;

import realObject.AccountImpl;
import impl.Account;

public class Proxy implements Account {
	private Account account;
	
	public Proxy() {
		// TODO Auto-generated constructor stub
		account=new AccountImpl();
	}

	@Override
	public void queryAccount() {
		// TODO Auto-generated method stub
		System.out.println("ʵ���ѯ����ǰ");
		account.queryAccount();
		System.out.println("ʵ���ѯ������");
	}

	@Override
	public void updateAccount() {
		// TODO Auto-generated method stub
		System.out.println("ʵ����·���ǰ");
		account.updateAccount();
		System.out.println("ʵ����·�����");
	}

}
