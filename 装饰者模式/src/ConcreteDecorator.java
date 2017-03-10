public class ConcreteDecorator implements Decorator {
	private Component decoratedComponent;

	/**
	 * 代理模式一定是自身持有这个对象，不需要从外部传入。 而装饰模式的一定是从外部传入，并且可以没有顺序，按照代码的实际需求随意挑换顺序，
	 * 就如你吃火锅先放白菜还是先放丸子都可以。
	 */
	public ConcreteDecorator(Component decoratedComponent) {
		// TODO Auto-generated constructor stub
		this.decoratedComponent = decoratedComponent;
	}

	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("decorated operation!");
		decoratedComponent.operation();
	}

	@Override
	public void addedBehavior() {
		// TODO Auto-generated method stub
		System.out.println("addedBehaviour!");
	}

}
