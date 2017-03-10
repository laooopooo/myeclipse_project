
public class ConcreteObserver implements Observer{
	private String name;
	
	public ConcreteObserver(String name){
		this.name=name;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Œ“ «"+name);
	}

}
