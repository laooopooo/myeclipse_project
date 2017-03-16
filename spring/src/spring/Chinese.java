package spring;

public class Chinese implements Person {
	private Axe axe;

	public Chinese() {
		// TODO Auto-generated constructor stub
		System.out.println("Chinese的无参构造函数");
	}

	public Axe getAxe() {
		return axe;
	}

	public void setAxe(Axe axe) {
		System.out.println("Chinese的依赖关系注入（其实就是set（）方法）");
		this.axe = axe;
	}

	@Override
	public void useAxe() {
		// TODO Auto-generated method stub
		System.out.println(axe.chop());
	}

}
