package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static boolean isDaffodil(int m) {
		int oldValue = m;
		double result = 0;
		while (m > 0) {
			int temp = m % 10;
			result += Math.pow(temp, 3);
			m = m / 10;
		}
		if (result == oldValue) {
			return true;
		}
		return false;

	}

	public static ArrayList<Integer> allDaffodil(int m, int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = m; i <= n; i++) {
			if (isDaffodil(i)) {
				list.add(i);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m;
		int n;
		while (sc.hasNextInt()) {
			m = sc.nextInt();
			n = sc.nextInt();
			ArrayList<Integer> list = allDaffodil(m, n);
			if (list.size() == 0) {
				System.out.println("no");
			}
			for (Integer i : list) {
				System.out.print(i + " ");
			}
		}
	}
}
