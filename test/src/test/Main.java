package test;

import java.util.Scanner;

public class Main {

	// ����m��ƽ����
	public static double f(double n) {
		return Math.sqrt(n);
	}

	// ����m��ǰn���
	public static double f(double n, double m) {
		double result = 0;
		double now = n;
		for (int i = 0; i < m; i++) {
			result += now;
			now = f(now);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int m;
		while (sc.hasNextInt()) {
			n = sc.nextInt();
			m = sc.nextInt();
			System.out.printf("%.2f", f((double) n, (double) m));
		}
	}
}
