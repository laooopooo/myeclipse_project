package dynamic;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler {
	private Object delegate;

	public Object getInstance(Object delegate) {
		this.delegate = delegate;
		return java.lang.reflect.Proxy.newProxyInstance(delegate.getClass()
				.getClassLoader(), delegate.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result=null;
		try{
			System.out.println(delegate.getClass()+"执行"+method.getName()+"前");
			method.invoke(delegate,args);
			System.out.println(delegate.getClass()+"执行"+method.getName()+"后");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

}
