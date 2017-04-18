import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	static {
		sc = new Scanner(System.in);
	}

	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		int[] intNums = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			intNums[i] = nums.get(i);
		}

		int result = Integer.MIN_VALUE;
		for (int i = 1; i < intNums.length; i++) {
			int temp = maxSubArray(intNums, 0, i)
					+ maxSubArray(intNums, i, intNums.length);
			result = result > temp ? result : temp;
		}
		return result;
	}

	public int maxSubArray(int[] nums, int begin, int end) {
		if (begin < 0 || end > nums.length || begin >= end) {
			throw new RuntimeException();
		}

		int sum = Integer.MIN_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for (int i = begin; i < end; i++) {
			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			maxVal = maxVal > sum ? maxVal : sum;
		}
		return maxVal;
	}

	public static void main(String[] args) throws IOException {
		Main fds = new Main();
		int testCase = sc.nextInt();

		for (int i = 0; i < testCase - 1; i++) {
			int length = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < length; j++) {
				list.add(sc.nextInt());
			}
			System.out.print(fds.maxTwoSubArrays(list) + "");
			System.out.print("\n");
		}

		int length = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < length; j++) {
			list.add(sc.nextInt());
		}
		System.out.print(fds.maxTwoSubArrays(list) + "");

	}
}
