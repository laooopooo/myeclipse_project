package spring;

public class Chinese implements Person {
	private Axe axe;

	public Chinese() {
		// TODO Auto-generated constructor stub
		System.out.println("Chinese���޲ι��캯��");
	}

	public Axe getAxe() {
		return axe;
	}

	public void setAxe(Axe axe) {
		System.out.println("Chinese��������ϵע�루��ʵ����set����������");
		this.axe = axe;
	}

	@Override
	public void useAxe() {
		// TODO Auto-generated method stub
		System.out.println(axe.chop());
	}

}
