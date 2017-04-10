package domain;

<<<<<<< HEAD
class Holder<T> {

}

class H extends Holder {

}

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		// List<Character> l = new ArrayList<Character>(Arrays.asList('1', '2',
		// '3', '4'));
		// System.out.println(l);
		// List<Character> l2 = new ArrayList<Character>(l);
		// System.out.println(l2);

		// Object[] os = new Object[1];
		// os[0] = "1";
		//
		// String[] ss = new String[1];
		// ss[0] = (String) os[0];
		//
		// ss = (String[]) os;
		//
		// int i = Integer.MAX_VALUE;
		//
		// byte c = 9;
		//
		// c = (byte) i;
		// System.out.println(c);

		String s = "123";
		String s3 = "123";
		String s2 = new String("123");
		System.out.println(s == s3);
=======
import java.util.Arrays;

class Base {
	public void set(Base base) {
		System.out.println("Base中的set（base）");
	}
}

class Derived<T> extends Base {

	public void set(T t) {
		System.out.println("我是使用的泛型参数的set（）");
	}

	public void set(Base derived) {
		System.out.println("Derived中的set（derived）");
	}
}
>>>>>>> 8fb97d24fd455f781f22527cd74decd2c85bfdbc

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		// Set<String> s = new LinkedHashSet();
		//
		// for (Method m : AbstractList.class.getMethods()) {
		// if (Modifier.isAbstract(m.getModifiers())) {
		// s.add(m.getName());
		// }
		// }
		// System.out.println(s);

		String[] s = "A B C D".split(" ");
		System.out.println(s.length);
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + "  ");
		}
		System.out.println();
		System.out.println(s.getClass());
		String[] s2 = Arrays.copyOf(s, 10);
		for (int i = 0; i < s2.length; i++) {
			System.out.println(s2[i]);
		}
		System.out.println(s2.length);
	}
}
