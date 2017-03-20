import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

//归并数据生成器
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
			// true是追加模式
			// false是重写模式
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, false)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bw;
	}

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

	/**
	 * 随机生成无序元素
	 * 
	 * @param length
	 *            无序元素个数
	 * @param maxNum
	 *            元素最大值
	 * @param minNum
	 *            元素最小值
	 * @return 无序元素数组
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
	 * 随机生成有序元素
	 * 
	 * @param length
	 *            有序元素个数
	 * @param maxNum
	 *            元素最大值
	 * @param minNum
	 *            元素最小值
	 * @return 有序元素数组
	 */
	public static int[] generateOrderedDatas(int length, int maxNum, int minNum) {
		// 先生成无序元素
		int[] result = generateUnorderedDatas(length, maxNum, minNum);
		// 排序
		mergeSort(result, 0, result.length - 1);
		return result;

	}

	/**
	 * 向文件中追加无序元素，没有/n
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
	 * 向文件中追加有序元素,没有/n
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
