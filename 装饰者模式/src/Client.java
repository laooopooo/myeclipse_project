public class Client {
	public static void main(String[] args) {
		Component component=new ConcreteComponent();
		component.operation();
		System.out.println("我是快乐的分隔符···············");
		Decorator decorator=new ConcreteDecorator(component);
		decorator.operation();
		decorator.addedBehavior();
	}
}
