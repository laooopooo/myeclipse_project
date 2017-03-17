package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler {
	private Object target;// 实现类的一个对象

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result;
		System.out.println("开始执行一个方法:" + method.getName());
		result = method.invoke(target, args);// 这一行代码就等于执行实现类中的相应方法
		System.out.println("结束执行一个方法:" + method.getName());
		return result;
	}

	// 需要自己写一个方法，返回一个动态生成的代理类对象
	public Object getInstance(Object target) {
		this.target = target;
		/**
		 * this是一个实现了InvocationHandler接口的类的对象，返回的代理类对象
		 */
		return java.lang.reflect.Proxy.newProxyInstance(target.getClass()
				.getClassLoader(), target.getClass().getInterfaces(), this);
	}
}
