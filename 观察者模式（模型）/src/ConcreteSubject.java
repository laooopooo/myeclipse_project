import java.util.ArrayList;
import java.util.List;



public class ConcreteSubject implements Subject{
	private List<Observer> observers=new ArrayList<Observer>();
	
	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer e :observers) {
			e.update();
		}
	}

}
