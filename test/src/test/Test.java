package test;

public class Test {
	static void f() {
		try {
			System.out.println("try�Ӿ�");
			return;
		} finally {
			System.out.println("finally�Ӿ�");
		}
	}

	public static void main(String[] args) {
		f();
	}
}
