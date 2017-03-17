import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Solution {
	// ��Ҫ��ȡ�ļ���·��
	private static String fileReadName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// ��Ҫд���ļ���·��
	private static String fileWriteName = "C:\\Users\\Administrator\\Desktop\\2.txt";

	// ��ǰ�����ڵ����������ϲ���һ�������
	public static void merge(int nums[], int low, int mid, int high) {
		// ��һ������� low-mid
		// �ڶ��������mid+1-high
		int[] tempNums = new int[nums.length];
		// ��ԭ����Ԫ�ظ��Ƶ���ʱ������
		for (int k = low; k <= high; k++) {
			tempNums[k] = nums[k];
		}
		int i;
		int j;
		int k;
		for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
			// ��Сֵ���Ƶ�ԭ������
			if (tempNums[i] <= tempNums[j]) {
				nums[k] = tempNums[i++];
			} else {
				nums[k] = tempNums[j++];
			}

		}
		// ����һ����δ����꣬����
		while (i <= mid) {
			nums[k++] = tempNums[i++];
		}
		// ���ڶ�����Ϊ����꣬����
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

	// ʹ��Scanner��ȡ�ļ�
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

	// ʹ��BufferedWriteд�ļ�
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

		// main��������Ҫ�Ƕ�ȡ�ļ�
		Scanner sc = createScanner();
		// д�ļ�
		BufferedWriter bw = createWrite();
		// ��ȡʵ����������
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
