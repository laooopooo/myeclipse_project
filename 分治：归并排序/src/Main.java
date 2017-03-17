import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void merge(int nums[], int low, int mid, int high) {
		int[] tempNums = new int[nums.length];
		for (int k = low; k <= high; k++) {
			tempNums[k] = nums[k];
		}
		int i;
		int j;
		int k;
		for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
			if (tempNums[i] <= tempNums[j]) {
				nums[k] = tempNums[i++];
			} else {
				nums[k] = tempNums[j++];
			}

		}
		while (i <= mid) {
			nums[k++] = tempNums[i++];
		}
		while (j <= high) {
			nums[k++] = tempNums[j++];
		}

	}

	public static void mergeSort(int nums[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(nums, low, mid);
			mergeSort(nums, mid + 1, high);
			merge(nums, low, mid, high);
		}
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int testTimes = sc.nextInt();
		for (int i = 0; i < testTimes; i++) {
			int numsLength = sc.nextInt();
			int nums[] = new int[numsLength];
			for (int j = 0; j < numsLength; j++) {
				nums[j] = sc.nextInt();
			}
			// ÅÅÐò
			mergeSort(nums, 0, numsLength - 1);
			for (int k = 0; k < nums.length - 1; k++) {
				System.out.print(nums[k] + " ");
			}
			System.out.print(nums[nums.length - 1]);
			if (i != testTimes - 1) {
				System.out.println();
			}
		}
	}
}
