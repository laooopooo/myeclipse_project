import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	static {
		sc = new Scanner(System.in);
	}

	public int longestIncreasingSubsequence(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] memo = new int[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Integer.MIN_VALUE;
		}
		memoSubLIS(nums, nums.length - 1, memo);
		return maxArrays(memo, memo.length - 1);
	}

	public int memoSubLIS(int[] nums, int index, int[] memo) {
		int result = 0;

		if (memo[index] != Integer.MIN_VALUE) {
			return memo[index];
		}

		if (index == 0) {
			memo[index] = 1;
			return 1;
		} else {
			for (int i = 0; i < index; i++) {

				int tempLis = 0;
				int memoI = memoSubLIS(nums, i, memo);
				if (nums[index] > nums[i]) {
					tempLis = memoI + 1;
				} else {
					tempLis = 1;
				}
				result = max(result, tempLis);
			}
		}

		memo[index] = result;
		return result;
	}

	public int maxArrays(int[] nums, int index) {
		if (index >= nums.length) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= index; i++) {
			max = max > nums[i] ? max : nums[i];
		}
		return max;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) throws IOException {
		Main fds = new Main();
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase - 1; i++) {
			int num = sc.nextInt();
			int[] nums = new int[num];
			for (int j = 0; j < num; j++) {
				nums[j] = sc.nextInt();
			}
			System.out.print(fds.longestIncreasingSubsequence(nums) + "\n");
		}
		int num = sc.nextInt();
		int[] nums = new int[num];
		for (int j = 0; j < num; j++) {
			nums[j] = sc.nextInt();
		}
		System.out.print(fds.longestIncreasingSubsequence(nums) + "");
	}
}
