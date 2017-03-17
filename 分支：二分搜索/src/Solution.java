import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Solution {
	// 需要读取文件的路径
	private static String fileReadName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// 需要写入文件的路径
	private static String fileWriteName = "C:\\Users\\Administrator\\Desktop\\2.txt";

	public static int binarySerach(int[] nums, int start, int end, int num) {
		if (end < start) {
			// 这时表明没有找到该数
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

	// 使用Scanner读取文件
	public static Scanner createScanner(String fileReadName) {
		Scanner sc = null;
		File file = new File(fileReadName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("success read file,the file is " + fileReadName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sc;
	}

	public static BufferedWriter createWrite(String fileWriteName)
			throws UnsupportedEncodingException {
		File file = new File(fileWriteName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out
					.println("success open file,the file is " + fileWriteName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, false)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bw;
	}

	public static void main(String[] args) {// main方法中主要是读取文件
		Scanner sc = createScanner(fileReadName);
		// 读取数组值
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
			if (index == -1) {
				result[i] = "Not found!";
			} else {
				result[i] = String.valueOf(index);
			}
		}
		BufferedWriter bw = DataGenerator.createWrite(fileWriteName);
		DataGenerator.writeArray(result);
		DataGenerator.close();
	}
}
