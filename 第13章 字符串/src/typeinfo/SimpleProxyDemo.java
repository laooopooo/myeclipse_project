package typeinfo;

import static net.mindview.util.Print.print;

interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

class RealObject implements Interface {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		print("doSomething");
	}

	@Override
	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		print("somethingElse " + arg);
	}

}

class SimpleProxy implements Interface {
	private Interface proxied;
	private int invokeDoSomethingTimes = 0;
	private int invo

	public SimpleProxy() {
		// TODO Auto-generated constructor stub
		this.proxied = new RealObject();
	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		print("SimpleProxy doSomething");
		proxied.doSomething();
		invokeDoSomethingTimes++;
		print("doSomething have been invoke " + invokeDoSomethingTimes + "");
	}

	@Override
	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		print("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
	}
}

public class SimpleProxyDemo {

	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy());
	}

}
