
public abstract class Command {
	protected Account account;
	
	public Command(Account account) {
		// TODO Auto-generated constructor stub
		this.account=account;
	}
	
	public abstract  void execute();
}
