
public class MoneyInCommand extends Command{
	private double amount;

	public MoneyInCommand(Account account,double amount) {
		super(account);
		this.amount=amount;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		account.moneyIn(amount);
	}
	
	
}
