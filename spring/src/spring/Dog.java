package spring;

public class Dog implements Being {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void testBeing() {
		// TODO Auto-generated method stub
		System.out.println("DogµÄtestBeing");
	}

}
