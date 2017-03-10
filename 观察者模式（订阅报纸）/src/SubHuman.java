
public class SubHuman implements ISubscribe{
	private String name;
	
	public SubHuman(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	@Override
	public void hasNewPaper() {
		// TODO Auto-generated method stub
		System.out.println(name+"!!,有新的报纸了。");
	}

}
