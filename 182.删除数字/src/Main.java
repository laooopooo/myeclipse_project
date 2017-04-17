import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	static {
		sc = new Scanner(System.in);
	}

	public String DeleteDigits(String A, int k) {
		StringBuffer sb = new StringBuffer(A);
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < sb.length(); j++) {
				if (j == sb.length() - 1 || j + 1 < sb.length()
						&& sb.charAt(j) > sb.charAt(j + 1)) {
					sb.deleteCharAt(j);
					break;
				}
			}
		}
		if (sb.length() == 0) {
			return "0";
		}
		boolean allZero = true;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != '0') {
				allZero = false;
				break;
			}
		}
		if (allZero) {
			return "0";
		}

		int index = 0;
		while (sb.charAt(index) == '0') {
			index++;
		}
		return sb.toString().substring(index);
	}

	public static void main(String[] args) throws IOException {
		Main fds = new Main();

		int testCase = sc.nextInt();
		String s1;
		int k;
		for (int i = 0; i < testCase - 1; i++) {
			s1 = sc.next();
			k = sc.nextInt();
			System.out.print(fds.DeleteDigits(s1, k) + "\n");
		}

		s1 = sc.next();
		k = sc.nextInt();
		System.out.print(fds.DeleteDigits(s1, k) + "");

	}
}
