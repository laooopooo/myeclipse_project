import java.util.Scanner;

public class Main {

	public static long climbStairs(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		// 索引为0的位置不存放值
		long[] r = new long[n + 1];
		// 初始化边界
		r[1] = 1;
		r[2] = 2;

		for (int i = 3; i <= n; i++) {
			r[i] = r[i - 1] + r[i - 2];
		}
		return r[n];
	}

	public static long climbStairs2(int n) {
		// write your code here
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairs2(n - 1) + climbStairs2(n - 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxNum = sc.nextInt();
		for (int i = 0; i < maxNum - 1; i++) {
			int n = sc.nextInt();
			System.out.println(climbStairs(n));
		}
		int n = sc.nextInt();
		System.out.println(climbStairs(n));
	}
}
