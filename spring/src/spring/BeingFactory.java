package spring;

public class BeingFactory {

	public static Being getBeing(String arg) {
		if (arg.equalsIgnoreCase("dog")) {
			return new Dog();
		} else if (arg.equalsIgnoreCase("cat")) {
			return new Cat();
		}
		return null;
	}

}
