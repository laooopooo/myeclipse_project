import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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

	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		// write your code
		// ��list��Ϊ���飬����������������͵ĺ���
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

	// Ѱ�Ҵ�begin��end-1�е����������
	// 0=<begin<end<=nums.length
	public int maxSubArray(int[] nums, int begin, int end) {
		if (begin < 0 || end > nums.length || begin >= end) {
			throw new RuntimeException("�߽����begin��" + begin + ",end: " + end);
		}

		int sum = Integer.MIN_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for (int i = begin; i < end; i++) {
			// ��sum<0��˵������һ��������������֮��С��0������һ�����������ֵ�Ѿ�����¼
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
		FileDataSolution fds = new FileDataSolution();
		int testCase = sc.nextInt();

		for (int i = 0; i < testCase - 1; i++) {
			int length = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < length; j++) {
				list.add(sc.nextInt());
			}
			bw.write(fds.maxTwoSubArrays(list) + "");
			bw.write("\n");
		}

		int length = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < length; j++) {
			list.add(sc.nextInt());
		}
		bw.write(fds.maxTwoSubArrays(list) + "");

		bw.close();
	}

}
