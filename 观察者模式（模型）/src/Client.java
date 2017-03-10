import java.util.Observable;

public class Client {
	public static void main(String[] args) {
		ConcreteSubject subject=new ConcreteSubject();
		
		ConcreteObserver xiaohua=new ConcreteObserver("小花");
		ConcreteObserver xiahou=new ConcreteObserver("夏侯");
		ConcreteObserver weiguangming=new ConcreteObserver("卫光明");
		
		subject.attach(xiahou);
		subject.attach(xiaohua);
		subject.attach(weiguangming);
		
		subject.notifyObservers();
	}

}
