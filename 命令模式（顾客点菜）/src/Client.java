
public class Client {
	public static void main(String[] args) {
		MM mm=new MM();
		mm.setOrder(new ReCaiOrder());
		mm.onOrder();
		mm.setOrder(new LiangCaiOrder());
		mm.onOrder();
	}
}
