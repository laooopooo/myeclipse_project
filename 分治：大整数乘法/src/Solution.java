import java.util.Arrays;

public class Solution {
	public char[] multi(char[] num1, char[] num2) {

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
