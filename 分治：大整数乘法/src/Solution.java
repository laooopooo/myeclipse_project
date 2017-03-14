import java.util.Arrays;

public class Solution {
	public char[] multi(char[] num1, char[] num2) {

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
