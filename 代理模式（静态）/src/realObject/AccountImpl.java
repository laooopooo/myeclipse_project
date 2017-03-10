package realObject;

import impl.Account;

public class AccountImpl implements Account{

	@Override
	public void queryAccount() {
		// TODO Auto-generated method stub
		System.out.println("我是实体的查询方法");
	}

	@Override
	public void updateAccount() {
		// TODO Auto-generated method stub
		System.out.println("我是实体的更新方法");
	}

}
