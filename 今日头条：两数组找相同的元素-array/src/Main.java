import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<Integer> f(int[] a, int[] b) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < b.length; j++) {
			boolean contain = false;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == b[j]) {
					contain = true;
					break;
				}
			}

			if (contain == true) {
				list.add(b[j]);
			}

		}

		return list;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lengthA = sc.nextInt();
		int[] a = new int[lengthA];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int lengthB = sc.nextInt();
		int[] b = new int[lengthB];
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		ArrayList<Integer> list = f(a, b);
		StringBuilder sb = new StringBuilder();
		for (Integer i : list) {
			sb.append(i + " ");
		}
		sb.delete(sb.length() - 1, sb.length());
		System.out.print(sb);

	}

}
