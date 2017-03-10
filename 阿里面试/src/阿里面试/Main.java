package ∞¢¿Ô√Ê ‘;

public class Main {
	public static void f(Person p, int i) {
		p.a = 30;
		i = 20;
	}

	public static void main(String[] args) {
		int i = 10;
		Person p = new Person();
		p.a = 15;
		System.out.println(i);
		System.out.println(p.a);
		f(p, i);
		System.out.println(i);
		System.out.println(p.a);
	}

}
