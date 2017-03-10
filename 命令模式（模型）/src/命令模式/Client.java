package ÃüÁîÄ£Ê½;

public class Client {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		ConcreteCommand command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invoker.runCommand();
	}
}
