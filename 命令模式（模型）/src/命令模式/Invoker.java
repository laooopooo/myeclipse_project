package ÃüÁîÄ£Ê½;

public class Invoker {
	private ICommand command;

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public void runCommand() {
		command.execute();
	}
}
