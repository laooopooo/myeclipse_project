import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	static {
		sc = new Scanner(System.in);
	}

	public int backPack(int m, int[] A) {

		int memo[][] = new int[m + 1][A.length + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < A.length + 1; j++) {
				memo[i][j] = -1;
			}
		}
		return memoSubBackPackAux(m, A, A.length - 1, memo);
	}

	public int memoSubBackPackAux(int m, int[] A, int num, int[][] memo) {
		int result = 0;

		if (memo[m][num] != -1) {
			return memo[m][num];
		}

		if (num == 0) {

			if (m >= A[num]) {
				result = A[num];
			}

			else {

				result = 0;
			}
		} else if (m >= A[num]) {
			result = max(memoSubBackPackAux(m, A, num - 1, memo),
					(A[num] + memoSubBackPackAux(m - A[num], A, num - 1, memo)));
		} else {
			result = memoSubBackPackAux(m, A, num - 1, memo);
		}

		memo[m][num] = result;
		return result;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) throws IOException {
		Main fds = new Main();
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase - 1; i++) {
			int backPackCapacity = sc.nextInt();
			int goodNum = sc.nextInt();
			int[] goodWeightNums = new int[goodNum];
			for (int j = 0; j < goodNum; j++) {
				goodWeightNums[j] = sc.nextInt();
			}
			System.out.print(fds.backPack(backPackCapacity, goodWeightNums)
					+ "\n");
		}
		int backPackCapacity = sc.nextInt();
		int goodNum = sc.nextInt();
		int[] goodWeightNums = new int[goodNum];
		for (int j = 0; j < goodNum; j++) {
			goodWeightNums[j] = sc.nextInt();
		}
		System.out.print(fds.backPack(backPackCapacity, goodWeightNums) + "");
	}
}
