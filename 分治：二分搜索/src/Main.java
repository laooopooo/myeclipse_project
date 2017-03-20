import java.util.Scanner;

public class Main {
	public static int binarySerach(int[] nums, int start, int end, int num) {
		if (end < start) {
			return -1;
		}
		int average = (start + end) / 2;
		if (nums[average] == num) {
			return average;
		} else if (nums[average] < num) {
			return binarySerach(nums, average + 1, end, num);
		} else if (nums[average] > num) {
			return binarySerach(nums, start, average - 1, num);
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numLength = sc.nextInt();
		int[] nums = new int[numLength];
		for (int i = 0; i < numLength; i++) {
			nums[i] = sc.nextInt();
		}
		int searchLength = sc.nextInt();
		int[] intSearchResult = new int[searchLength];
		String[] result = new String[searchLength];
		for (int i = 0; i < searchLength; i++) {
			int searchNum = sc.nextInt();
			int index = binarySerach(nums, 0, nums.length - 1, searchNum);
			if (i != searchLength - 1) {
				if (index == -1) {
					System.out.print("Not found! ");
				} else {
					System.out.print(index + " ");
				}
			} else {
				if (index == -1) {
					System.out.print("Not found!");
				} else {
					System.out.print(index);
				}
			}
		}
	}

}
