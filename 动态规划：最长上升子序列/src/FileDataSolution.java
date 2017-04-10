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

		// ��ʼ��memo
		// memo[i]��ŵ����Ե�i��Ԫ��Ϊ�������յ�ʱ�����г���
		// ���Ҫ��Ӱ���0~i����Ԫ�ص�������У�Ϊmemo[0]~memo[i]�����ֵ
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
	 * @return ������nums�д�0~indexԪ���е�LIS,���ص���memo�����ֵ��memo��������ֵ����LIS
	 */
	public int memoSubLIS(int[] nums, int index, int[] memo) {
		int result = 0;

		// ���ұ���
		if (memo[index] != Integer.MIN_VALUE) {
			return memo[index];
		}

		// �߽�
		if (index == 0) {
			memo[index] = 1;
			return 1;
		}
		/**
		 * index��LIS����0~index��LIS����index��LIS������ֵ
		 */
		else {
			for (int i = 0; i < index; i++) {

				int tempLis = 0;
				// �Ե�index��Ԫ��Ϊ�յ�����������к�
				int memoI = memoSubLIS(nums, i, memo);
				// ��ǰԪ�ش���nums[i]
				if (nums[index] > nums[i]) {
					tempLis = memoI + 1;
				}
				// ��ǰԪ�ز�����nums[i]
				else {
					tempLis = 1;
				}
				result = max(result, tempLis);
			}
		}

		// ���±���
		memo[index] = result;
		return result;
	}

	/**
	 * 
	 * @param nums
	 * @param index
	 * @return ������nums�д�0~indexԪ��������Ԫ��
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
	 * @return �������е����ֵ
	 */
	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) throws IOException {
		FileDataSolution fds = new FileDataSolution();
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase - 1; i++) {
			// ��ʼ������
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
