package staticModel;

public class Proxy implements TimeAccountInterface,TimeBookInterface{
	private TimeAccountInterface tai;
	private TimeBookInterface tbi;
	
	public Proxy() {
		// TODO Auto-generated constructor stub
		tai=new TimeAccount();
		tbi=new TimeBook();
	}

	@Override
	public void doAuditing() {
		// TODO Auto-generated method stub
		
		System.out.println(tbi.getClass()+"执行"+"前");
		tbi.doAuditing();
		System.out.println(tbi.getClass()+"执行"+"后");
	}

	@Override
	public void doAccount() {
		// TODO Auto-generated method stub
		System.out.println(tai.getClass()+"执行"+"前");
		tai.doAccount();
		System.out.println(tai.getClass()+"执行"+"后");
	}

}
