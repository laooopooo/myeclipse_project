import java.util.Scanner;

public class Main {
	public static int fastPower(int a, int b, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return a % b;
		}
		int temp = fastPower(a, b, n / 2);
		if ((n & 1) == 1) {
			return ((temp * temp) % b * a % b) % b;
		} else {
			return (temp * temp) % b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testNums = sc.nextInt();
		for (int i = 0; i < testNums - 1; i++) {
			int a = sc.nextInt();
			int n = sc.nextInt();
			int b = sc.nextInt();
			int result = fastPower(a, b, n);
			System.out.println(result);
		}
		int a = sc.nextInt();
		int n = sc.nextInt();
		int b = sc.nextInt();
		int result = fastPower(a, b, n);
		System.out.print(result);
	}
}
