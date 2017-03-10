package test;

import proxy.Proxy;
import realsubject.AccountImpl;
import impl.Account;

public class Test {
	public static void main(String[] args) {
		Proxy proxy=new Proxy();
		Account account=(Account)proxy.getInstance(new AccountImpl());
		account.queryAcount();
		account.updateAccount();
	}
}
