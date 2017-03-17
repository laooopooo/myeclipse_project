package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler {
	private Object target;// ʵ�����һ������

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result;
		System.out.println("��ʼִ��һ������:" + method.getName());
		result = method.invoke(target, args);// ��һ�д���͵���ִ��ʵ�����е���Ӧ����
		System.out.println("����ִ��һ������:" + method.getName());
		return result;
	}

	// ��Ҫ�Լ�дһ������������һ����̬���ɵĴ��������
	public Object getInstance(Object target) {
		this.target = target;
		/**
		 * this��һ��ʵ����InvocationHandler�ӿڵ���Ķ��󣬷��صĴ��������
		 */
		return java.lang.reflect.Proxy.newProxyInstance(target.getClass()
				.getClassLoader(), target.getClass().getInterfaces(), this);
	}
}
