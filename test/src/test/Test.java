package test;

public class Test {
	static void f() {
		try {
			System.out.println("try×Ó¾ä");
			return;
		} finally {
			System.out.println("finally×Ó¾ä");
		}
	}

	public static void main(String[] args) {
		f();
	}
}
