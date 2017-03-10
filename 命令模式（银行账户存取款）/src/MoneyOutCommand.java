

public class MoneyOutCommand extends Command{
	private double amount;
	

	public MoneyOutCommand(Account account,double amount) {
		super(account);
		this.amount=amount;
		// TODO Auto-generated constructor stub
	}



	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		account.moneyOut(amount);
	}
}
