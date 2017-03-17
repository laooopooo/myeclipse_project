import java.util.Arrays;

public class Solution {
	// 小于此位数直接计算
	private final static int SIZE = 4;

	public char[] multi(char[] num1, char[] num2) {
		char[] result = null;
		if (num1.length <= SIZE && num2.length <= SIZE) {
			String s1 = String.valueOf(num1);
			String s2 = String.valueOf(num2);
		}

		// 把两个数组都分成两部分，若数组长度为奇数，则高位补0后再分为两部分
		// a，b是num1的两部分
		int num1HalfLength = num1.length % 2 == 0 ? num1.length / 2
				: (num1.length + 1) / 2;

		char[] a = new char[num1HalfLength];
		char[] b = new char[num1HalfLength];
		// c，d是num2的两部分
		int num2HalfLength = num2.length % 2 == 0 ? num2.length / 2
				: (num2.length + 1) / 2;
		char[] c = new char[num2HalfLength];
		char[] d = new char[num2HalfLength];
		split(num1, a, b);
		split(num2, c, d);

		// 大整数乘法分解为四部分
		// 两个低位相乘
		char[] result1 = multi(b, d);
		// num1高位和num2低位
		char[] tempResult = multi(a, d);
		char[] result2 = new char[tempResult.length + num1HalfLength];
		// 高位复制
		System.arraycopy(tempResult, 0, result2, 0, tempResult.length);
		// 低位补0
		for (int i = tempResult.length; i < result2.length; i++) {
			result2[i] = '0';
		}
		// num2低位和num1高位
		tempResult = multi(b, c);
		char[] result3 = new char[tempResult.length + num2HalfLength];
		// 高位复制
		System.arraycopy(tempResult, 0, result3, 0, tempResult.length);
		// 低位补0
		for (int i = tempResult.length; i < result3.length; i++) {
			result3[i] = '0';
		}
		// num1高位和num2高位
		tempResult = multi(a, c);
		char[] result4 = new char[tempResult.length + num1HalfLength
				+ num2HalfLength];
		// 高位复制
		System.arraycopy(tempResult, 0, result4, 0, tempResult.length);
		// 低位补0
		for (int i = tempResult.length; i < result4.length; i++) {
			result4[i] = '0';
		}
		// 四部分相加
		result = add(add(result3, result2), add(result1, result4));
		return result;
	}

	public void split(char[] nums, char[] high, char[] low) {
		// 长度为偶数
		if (nums.length % 2 == 0) {
			System.arraycopy(nums, nums.length / 2, low, 0, low.length);
			System.arraycopy(nums, 0, high, 0, high.length);

		}
		// 长度为奇数
		else {
			System.arraycopy(nums, nums.length / 2, low, 0, low.length);
			System.arraycopy(nums, 0, high, 1, nums.length / 2);
			high[0] = '0';
		}
	}

	/**
	 * 大整数加法
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public char[] add(char[] num1, char[] num2) {
		int maxLength;
		if (num1.length > num2.length) {
			maxLength = num1.length;
		} else {
			maxLength = num2.length;
		}
		// 存放结果的数组初始化
		char[] result = new char[maxLength + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = '0';
		}
		// 两个指针，指向当前需要相加的数组位置上
		int index1 = num1.length - 1;
		int index2 = num2.length - 1;
		int resultIndex = result.length - 1;
		// 进位标识符
		int hasJinwei = 0;

		int now1;
		int now2;
		// 只要有一个数组还没计算结束就继续遍历
		while (index1 >= 0 || index2 >= 0) {
			// 把char转为int
			if (index1 < 0) {
				now1 = 0;
			} else {
				now1 = num1[index1] - 48;
			}
			if (index2 < 0) {
				now2 = 0;
			} else {
				now2 = num2[index2] - 48;
			}
			// 如果相加有进位
			if (now1 + now2 + hasJinwei >= 10) {
				result[resultIndex] = (char) (now1 + now2 + hasJinwei - 10 + 48);
				hasJinwei = 1;
			}
			// 相加无进位
			else {
				result[resultIndex] = (char) (now1 + now2 + hasJinwei + 48);
				hasJinwei = 0;
			}
			// 指针-1，向高位继续运算
			index1--;
			index2--;
			resultIndex--;
		}

		// 如果最高位没进位
		if (hasJinwei != 1) {
			return Arrays.copyOfRange(result, 1, result.length);
		}
		// 最高位有进位
		else {
			result[0] = 1 + 48;
			return result;
		}

	}

}
