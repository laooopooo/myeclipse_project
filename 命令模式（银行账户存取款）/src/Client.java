
public class Client {
	public static void main(String[] args) {
		Account account=new Account();
		
		Command commandIn=new MoneyInCommand(account, 500);
		
		Invoker invoker=new Invoker();
		
		invoker.setCommand(commandIn);
		invoker.executeCommand();
		System.out.println("The current amount is"+account.getTotalAmount());
		
		Command commandIn2=new MoneyInCommand(account, 500);
		invoker.setCommand(commandIn2);
		invoker.executeCommand();
		System.out.println("The current amount is"+account.getTotalAmount());
		
		Command commandOut =new MoneyOutCommand(account, 300);
		invoker.setCommand(commandOut);
		invoker.executeCommand();
		System.out.println("The current amount is"+account.getTotalAmount());
	}
}
