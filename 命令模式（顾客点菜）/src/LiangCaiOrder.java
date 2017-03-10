
public class LiangCaiOrder implements IOrder{
	private LiangCaiChuShi chuShi=new LiangCaiChuShi();

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		chuShi.makeCook();
	}
	
	

}
