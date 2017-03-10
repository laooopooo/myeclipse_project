package ÃüÁîÄ£Ê½;

public class ConcreteCommand implements ICommand{
	private Receiver receiver;
	
	public ConcreteCommand(Receiver receiver) {
		// TODO Auto-generated constructor stub
		this.receiver=receiver;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.action();
	}
	
}
