import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	static {
		sc = new Scanner(System.in);
	}

	public boolean firstWillWin(int n) {
		if (n % 3 == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		Main fds = new Main();
		int testCase = sc.nextInt();
		int m;
		for (int i = 0; i < testCase - 1; i++) {
			m = sc.nextInt();
			System.out.print(fds.firstWillWin(m) + "\n");
		}

		m = sc.nextInt();
		System.out.print(fds.firstWillWin(m) + "");

	}
}
