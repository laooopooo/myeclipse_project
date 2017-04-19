package test;

class MyThread extends Thread {
	public static volatile int i = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		i++;
	}
}

public class Test {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new MyThread().start();
		}
		System.out.println(MyThread.i);
	}

}
