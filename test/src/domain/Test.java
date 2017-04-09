package domain;

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
