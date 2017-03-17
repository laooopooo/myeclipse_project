import java.util.Arrays;

public class Solution {
	// С�ڴ�λ��ֱ�Ӽ���
	private final static int SIZE = 4;

	public char[] multi(char[] num1, char[] num2) {
		char[] result = null;
		if (num1.length <= SIZE && num2.length <= SIZE) {
			String s1 = String.valueOf(num1);
			String s2 = String.valueOf(num2);
		}

		// ���������鶼�ֳ������֣������鳤��Ϊ���������λ��0���ٷ�Ϊ������
		// a��b��num1��������
		int num1HalfLength = num1.length % 2 == 0 ? num1.length / 2
				: (num1.length + 1) / 2;

		char[] a = new char[num1HalfLength];
		char[] b = new char[num1HalfLength];
		// c��d��num2��������
		int num2HalfLength = num2.length % 2 == 0 ? num2.length / 2
				: (num2.length + 1) / 2;
		char[] c = new char[num2HalfLength];
		char[] d = new char[num2HalfLength];
		split(num1, a, b);
		split(num2, c, d);

		// �������˷��ֽ�Ϊ�Ĳ���
		// ������λ���
		char[] result1 = multi(b, d);
		// num1��λ��num2��λ
		char[] tempResult = multi(a, d);
		char[] result2 = new char[tempResult.length + num1HalfLength];
		// ��λ����
		System.arraycopy(tempResult, 0, result2, 0, tempResult.length);
		// ��λ��0
		for (int i = tempResult.length; i < result2.length; i++) {
			result2[i] = '0';
		}
		// num2��λ��num1��λ
		tempResult = multi(b, c);
		char[] result3 = new char[tempResult.length + num2HalfLength];
		// ��λ����
		System.arraycopy(tempResult, 0, result3, 0, tempResult.length);
		// ��λ��0
		for (int i = tempResult.length; i < result3.length; i++) {
			result3[i] = '0';
		}
		// num1��λ��num2��λ
		tempResult = multi(a, c);
		char[] result4 = new char[tempResult.length + num1HalfLength
				+ num2HalfLength];
		// ��λ����
		System.arraycopy(tempResult, 0, result4, 0, tempResult.length);
		// ��λ��0
		for (int i = tempResult.length; i < result4.length; i++) {
			result4[i] = '0';
		}
		// �Ĳ������
		result = add(add(result3, result2), add(result1, result4));
		return result;
	}

	public void split(char[] nums, char[] high, char[] low) {
		// ����Ϊż��
		if (nums.length % 2 == 0) {
			System.arraycopy(nums, nums.length / 2, low, 0, low.length);
			System.arraycopy(nums, 0, high, 0, high.length);

		}
		// ����Ϊ����
		else {
			System.arraycopy(nums, nums.length / 2, low, 0, low.length);
			System.arraycopy(nums, 0, high, 1, nums.length / 2);
			high[0] = '0';
		}
	}

	/**
	 * �������ӷ�
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
		// ��Ž���������ʼ��
		char[] result = new char[maxLength + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = '0';
		}
		// ����ָ�룬ָ��ǰ��Ҫ��ӵ�����λ����
		int index1 = num1.length - 1;
		int index2 = num2.length - 1;
		int resultIndex = result.length - 1;
		// ��λ��ʶ��
		int hasJinwei = 0;

		int now1;
		int now2;
		// ֻҪ��һ�����黹û��������ͼ�������
		while (index1 >= 0 || index2 >= 0) {
			// ��charתΪint
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
			// �������н�λ
			if (now1 + now2 + hasJinwei >= 10) {
				result[resultIndex] = (char) (now1 + now2 + hasJinwei - 10 + 48);
				hasJinwei = 1;
			}
			// ����޽�λ
			else {
				result[resultIndex] = (char) (now1 + now2 + hasJinwei + 48);
				hasJinwei = 0;
			}
			// ָ��-1�����λ��������
			index1--;
			index2--;
			resultIndex--;
		}

		// ������λû��λ
		if (hasJinwei != 1) {
			return Arrays.copyOfRange(result, 1, result.length);
		}
		// ���λ�н�λ
		else {
			result[0] = 1 + 48;
			return result;
		}

	}

}
