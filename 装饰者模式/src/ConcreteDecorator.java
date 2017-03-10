public class ConcreteDecorator implements Decorator {
	private Component decoratedComponent;

	/**
	 * ����ģʽһ�����������������󣬲���Ҫ���ⲿ���롣 ��װ��ģʽ��һ���Ǵ��ⲿ���룬���ҿ���û��˳�򣬰��մ����ʵ��������������˳��
	 * ������Ի���ȷŰײ˻����ȷ����Ӷ����ԡ�
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
