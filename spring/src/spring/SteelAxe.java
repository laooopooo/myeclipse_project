package spring;

public class SteelAxe implements Axe {
	public SteelAxe() {
		// TODO Auto-generated constructor stub
		System.out.println("SteelAxe的无参构造函数");
	}

	@Override
	public String chop() {
		// TODO Auto-generated method stub
		return "SteelAxe的chop（）方法";
	}

}
