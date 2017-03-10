package test;

import proxy.Proxy;

/**
 *  好了，至此我们的静态代理实现了，
 *  但是问题也跟着来了，观察代码可以发现每一个代理类只能为一个接口服务，
 *  一个AccountProxy 类实现了一个Account接口，
 *  那么我要是有多个接口，是不是要写多个Proxy类与之对应。
 *  这样一来程序开发中必然会产生过多的代理，
 *  而且，所有的代理操作除了调用的方法不一样之外，其他的操作都一样，则此时肯定是重复代码。
 *  解决这一问题最好的做法是可以通过一个代理类完成全部的代理功能，那就引入了我们的动态代理了。
 * @author Administrator
 *
 */

public class Test {
	public static void main(String[] args) {
		Proxy proxy=new Proxy();
		
		proxy.queryAccount();
		proxy.updateAccount();
	}
}
