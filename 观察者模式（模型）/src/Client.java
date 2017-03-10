import java.util.Observable;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject subject=new ConcreteSubject();
		
		ConcreteObserver xiaohua=new ConcreteObserver("С��");
		ConcreteObserver xiahou=new ConcreteObserver("�ĺ�");
		ConcreteObserver weiguangming=new ConcreteObserver("������");
		
		subject.attach(xiahou);
		subject.attach(xiaohua);
		subject.attach(weiguangming);
		
		subject.notifyObservers();
	}

}
