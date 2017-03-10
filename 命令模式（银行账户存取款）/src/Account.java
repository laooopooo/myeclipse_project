public class Account {
	private double totalAmount;

	public void moneyIn(double amount) {
		this.totalAmount += amount;
	}

	public void moneyOut(double amount) {
		this.totalAmount -= amount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
}
