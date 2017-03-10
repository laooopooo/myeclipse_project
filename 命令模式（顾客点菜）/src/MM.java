
public class MM {
	IOrder order;
	
	public void setOrder(IOrder order){
		this.order=order;
	}
	
	public void onOrder(){
		order.execute();
	}
}
