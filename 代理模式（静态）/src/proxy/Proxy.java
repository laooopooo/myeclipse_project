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
		System.out.println("实体查询方法前");
		account.queryAccount();
		System.out.println("实体查询方法后");
	}

	@Override
	public void updateAccount() {
		// TODO Auto-generated method stub
		System.out.println("实体更新方法前");
		account.updateAccount();
		System.out.println("实体更新方法后");
	}

}
