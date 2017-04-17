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

	public int maxDiffSubArrays(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		int[] leftMax = new int[len];
		int[] rightMin = new int[len];
		int[] leftMin = new int[len];
		int[] rightMax = new int[len];
		int localMax = 0;
		int globalMax = Integer.MIN_VALUE;
		int localMin = 0;
		int globalMin = Integer.MAX_VALUE;

		for (int i = 0; i < len; i++) {
			localMax = Math.max(localMax + nums[i], nums[i]);
			globalMax = Math.max(localMax, globalMax);
			leftMax[i] = globalMax;

			localMin = Math.min(localMin + nums[i], nums[i]);
			globalMin = Math.min(localMin, globalMin);
			leftMin[i] = globalMin;
		}

		localMin = 0;
		globalMin = Integer.MAX_VALUE;
		localMax = 0;
		globalMax = Integer.MIN_VALUE;
		for (int i = len - 1; i >= 0; i--) {
			localMin = Math.min(localMin + nums[i], nums[i]);
			globalMin = Math.min(localMin, globalMin);
			rightMin[i] = globalMin;

			localMax = Math.max(localMax + nums[i], nums[i]);
			globalMax = Math.max(localMax, globalMax);
			rightMax[i] = globalMax;
		}
		int leftMAX = Integer.MIN_VALUE;
		int rightMAX = Integer.MIN_VALUE;

		for (int i = 0; i < len - 1; i++) {
			leftMAX = Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), leftMAX);
			rightMAX = Math.max(Math.abs(leftMin[i] - rightMax[i + 1]),
					rightMAX);
		}

		return Math.max(leftMAX, rightMAX);
	}

	public static void main(String[] args) throws IOException {
		FileDataSolution fds = new FileDataSolution();
		int testCase = sc.nextInt();

		for (int i = 0; i < testCase - 1; i++) {
			int length = sc.nextInt();
			int[] nums = new int[length];
			for (int j = 0; j < nums.length; j++) {
				nums[j] = sc.nextInt();
			}
			bw.write(fds.maxDiffSubArrays(nums) + "");
			bw.write("\n");
		}

		int length = sc.nextInt();
		int[] nums = new int[length];
		for (int j = 0; j < nums.length; j++) {
			nums[j] = sc.nextInt();
		}
		bw.write(fds.maxDiffSubArrays(nums) + "");

		bw.close();
	}

}
