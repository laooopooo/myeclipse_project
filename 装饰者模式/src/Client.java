public class Client {
	public static void main(String[] args) {
		Component component=new ConcreteComponent();
		component.operation();
		System.out.println("���ǿ��ֵķָ���������������������������������");
		Decorator decorator=new ConcreteDecorator(component);
		decorator.operation();
		decorator.addedBehavior();
	}
}
