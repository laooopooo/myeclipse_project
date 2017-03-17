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

	// 将前后相邻的两个有序表合并成一个有序表
	public static void merge(int nums[], int low, int mid, int high) {
		// 第一个有序表 low-mid
		// 第二个有序表mid+1-high
		int[] tempNums = new int[nums.length];
		// 把原数组元素复制到临时数组中
		for (int k = low; k <= high; k++) {
			tempNums[k] = nums[k];
		}
		int i;
		int j;
		int k;
		for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
			// 较小值复制到原数组中
			if (tempNums[i] <= tempNums[j]) {
				nums[k] = tempNums[i++];
			} else {
				nums[k] = tempNums[j++];
			}

		}
		// 若第一个表未检测完，复制
		while (i <= mid) {
			nums[k++] = tempNums[i++];
		}
		// 若第二个表为检测完，复制
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

	// 使用Scanner读取文件
	public static Scanner createScanner() {
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

	// 使用BufferedWrite写文件
	public static BufferedWriter createWrite()
			throws UnsupportedEncodingException {
		File file = new File(fileWriteName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("success create file,the file is "
					+ fileWriteName);
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

	public static void main(String[] args) throws IOException {

		// main方法中主要是读取文件
		Scanner sc = createScanner();
		// 写文件
		BufferedWriter bw = createWrite();
		// 读取实验数据组数
		int testTimes = sc.nextInt();
		for (int i = 0; i < testTimes; i++) {
			int numsLength = sc.nextInt();
			int nums[] = new int[numsLength];
			for (int j = 0; j < numsLength; j++) {
				nums[j] = sc.nextInt();
			}
			mergeSort(nums, 0, numsLength - 1);
			for (int k = 0; k < nums.length; k++) {
				if (k == nums.length - 1) {
					bw.write(nums[k] + "");
				} else {
					bw.write(nums[k] + " ");
				}

			}
			if (i != testTimes - 1) {
				bw.write("\n");
			}
		}
		sc.close();
		bw.close();

	}
}
