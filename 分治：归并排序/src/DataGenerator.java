import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

//�鲢����������
public class DataGenerator {
	private static BufferedWriter bw = null;

	public static BufferedWriter createWrite(String fileName) {
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("success create file,the file is " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// true��׷��ģʽ
			// false����дģʽ
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, false)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bw;
	}

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

	/**
	 * �����������Ԫ��
	 * 
	 * @param length
	 *            ����Ԫ�ظ���
	 * @param maxNum
	 *            Ԫ�����ֵ
	 * @param minNum
	 *            Ԫ����Сֵ
	 * @return ����Ԫ������
	 */
	public static int[] generateUnorderedDatas(int length, int maxNum,
			int minNum) {
		int[] result = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			result[i] = random.nextInt(maxNum - minNum) + minNum;
		}
		return result;
	}

	/**
	 * �����������Ԫ��
	 * 
	 * @param length
	 *            ����Ԫ�ظ���
	 * @param maxNum
	 *            Ԫ�����ֵ
	 * @param minNum
	 *            Ԫ����Сֵ
	 * @return ����Ԫ������
	 */
	public static int[] generateOrderedDatas(int length, int maxNum, int minNum) {
		// ����������Ԫ��
		int[] result = generateUnorderedDatas(length, maxNum, minNum);
		// ����
		mergeSort(result, 0, result.length - 1);
		return result;

	}

	/**
	 * ���ļ���׷������Ԫ�أ�û��/n
	 * 
	 * @param fileName
	 * @param length
	 * @param maxNum
	 * @param minNum
	 * @throws IOException
	 */
	public static void writeUnorderedDatas(int length, int maxNum, int minNum) {
		int[] result = generateUnorderedDatas(length, maxNum, minNum);
		try {
			for (int i = 0; i < result.length - 1; i++) {
				bw.write(result[i] + " ");
			}
			bw.write(result[length - 1] + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ļ���׷������Ԫ��,û��/n
	 * 
	 * @param fileName
	 * @param length
	 * @param maxNum
	 * @param minNum
	 * @throws IOException
	 */
	public static void writeOrderedDatas(int length, int maxNum, int minNum) {
		int[] result = generateUnorderedDatas(length, maxNum, minNum);
		mergeSort(result, 0, length - 1);
		try {
			for (int i = 0; i < result.length - 1; i++) {
				bw.write(result[i] + " ");
			}
			bw.write(result[length - 1] + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeArray(int[] nums) {
		try {
			for (int i = 0; i < nums.length - 1; i++) {
				bw.write(nums[i] + " ");
			}
			bw.write(nums[nums.length - 1] + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeArray(String[] strings) {
		try {
			for (int i = 0; i < strings.length - 1; i++) {
				bw.write(strings[i] + " ");
			}
			bw.write(strings[strings.length - 1] + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
