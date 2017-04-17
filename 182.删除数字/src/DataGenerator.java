import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

//归并数据生成器
public class DataGenerator {
	private static char[] chars = ("abcdefghijklmnopqrstuvwxyz"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

	// 将前后相邻的两个有序表合并成一个有序表
	private void merge(int nums[], int low, int mid, int high) {
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

	private void mergeSort(int nums[], int low, int high) {
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
	private int[] generateUnorderedDatas(int length, int maxNum, int minNum) {
		int[] result = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			result[i] = random.nextInt(maxNum - minNum) + minNum;
		}
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
	public String getUnorderedIntegers(int length, int maxNum, int minNum) {
		int[] result = generateUnorderedDatas(length, maxNum, minNum);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length - 1; i++) {
			sb.append(result[i]);
		}
		sb.append(result[length - 1]);
		return sb.toString();
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
	public String getOrderedIntegers(int length, int maxNum, int minNum) {
		int[] result = generateUnorderedDatas(length, maxNum, minNum);
		mergeSort(result, 0, length - 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length - 1; i++) {
			sb.append(result[i]);
		}
		sb.append(result[length - 1]);
		return sb.toString();
	}

	/**
	 * 
	 * @param length
	 *            生成String的长度
	 * @return 无序字符串
	 */
	public String getUnorderedString(int length) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(chars[rand.nextInt(chars.length)]);
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param length
	 *            生成String的长度
	 * @return 有序字符串
	 */
	public String getOrderedString(int length) {
		Random rand = new Random();
		char[] temp = new char[length];
		for (int i = 0; i < length; i++) {
			temp[i] = chars[rand.nextInt(chars.length)];
		}
		Arrays.sort(temp);
		return String.valueOf(temp);
	}

	public String getUnorderedString(int length, char[] chars) {
		Random rand = new Random();
		char[] temp = new char[length];
		temp[0] = chars[rand.nextInt(chars.length - 1) + 1];
		for (int i = 1; i < length; i++) {
			temp[i] = chars[rand.nextInt(chars.length)];
		}
		return String.valueOf(temp);
	}

}
