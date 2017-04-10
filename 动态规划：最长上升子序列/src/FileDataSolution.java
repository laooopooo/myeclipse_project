import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileDataSolution {
	private static String inputFileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	private static String outputFileName = "C:\\Users\\Administrator\\Desktop\\2.txt";
	private static Scanner sc;
	private static BufferedWriter bw;
	static {
		try {
			sc = new Scanner(new File(inputFileName));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outputFileName, false)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param nums
	 *            : The integer array
	 * @return: The length of LIS (longest increasing subsequence)
	 */
	public int longestIncreasingSubsequence(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// 初始化memo
		// memo[i]存放的是以第i个元素为子序列终点时的序列长度
		// 如果要求从包含0~i所有元素的最长子序列，为memo[0]~memo[i]的最大值
		int[] memo = new int[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Integer.MIN_VALUE;
		}
		memoSubLIS(nums, nums.length - 1, memo);
		return maxArrays(memo, memo.length - 1);
	}

	/**
	 * 
	 * @param nums
	 * @param index
	 * @param memo
	 * @return 在数组nums中从0~index元素中的LIS,返回的是memo数组的值，memo数组的最大值才是LIS
	 */
	public int memoSubLIS(int[] nums, int index, int[] memo) {
		int result = 0;

		// 查找备忘
		if (memo[index] != Integer.MIN_VALUE) {
			return memo[index];
		}

		// 边界
		if (index == 0) {
			memo[index] = 1;
			return 1;
		}
		/**
		 * index的LIS等于0~index的LIS更新index的LIS后的最大值
		 */
		else {
			for (int i = 0; i < index; i++) {

				int tempLis = 0;
				// 以第index个元素为终点的上升子序列和
				int memoI = memoSubLIS(nums, i, memo);
				// 当前元素大于nums[i]
				if (nums[index] > nums[i]) {
					tempLis = memoI + 1;
				}
				// 当前元素不大于nums[i]
				else {
					tempLis = 1;
				}
				result = max(result, tempLis);
			}
		}

		// 更新备忘
		memo[index] = result;
		return result;
	}

	/**
	 * 
	 * @param nums
	 * @param index
	 * @return 在数组nums中从0~index元素中最大的元素
	 */
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

	/**
	 * 
	 * @param a
	 * @param b
	 * @return 两个数中的最大值
	 */
	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) throws IOException {
		FileDataSolution fds = new FileDataSolution();
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase - 1; i++) {
			// 初始化数据
			int num = sc.nextInt();
			int[] nums = new int[num];
			for (int j = 0; j < num; j++) {
				nums[j] = sc.nextInt();
			}
			bw.write(fds.longestIncreasingSubsequence(nums) + "\n");
		}
		int num = sc.nextInt();
		int[] nums = new int[num];
		for (int j = 0; j < num; j++) {
			nums[j] = sc.nextInt();
		}
		bw.write(fds.longestIncreasingSubsequence(nums) + "");
		bw.close();
	}
}
