package test;

import java.util.Random;

class MyThread extends Thread {
	public static int i = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		i++;
	}
}

public class Test {
	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			System.out.println(r.nextInt());
		}

	}
}
