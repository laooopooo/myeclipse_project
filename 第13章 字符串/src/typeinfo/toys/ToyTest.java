package typeinfo.toys;

import static net.mindview.util.Print.print;

interface HasBatteries {

}

interface Waterproof {

}

interface Shoots {

}

interface USB {

}

class Toy {
	// public Toy() {
	// // TODO Auto-generated constructor stub
	// }

	public Toy(int i) {

	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, USB {
	public FancyToy() {
		// TODO Auto-generated constructor stub
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		print("Class name: " + cc.getName() + " is interface?["
				+ cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name: " + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("typeinfo.toys.FancyToy");
		} catch (ClassNotFoundException e) {
			print("Can't find FancyToy");
			System.exit(1);
		}

		printInfo(c);
		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			print("Can't instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			// TODO: handle exception
			print("Can't access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}
