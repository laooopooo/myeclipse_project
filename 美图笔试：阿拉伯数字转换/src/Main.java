import java.util.Scanner;

public class Main {

	private static final String[] units = { "ǧ", "��", "ʮ", "" };// ��λ

	private static final String[] bigUnits = { "��", "��" };

	private static final char[] numChars = { 'һ', '��', '��', '��', '��', '��', '��',
			'��', '��' };

	/**
	 * 
	 * ����������ת��Ϊ����������;
	 * 
	 * @param numberCN
	 * 
	 * @return
	 */
	public static long numberCN2Arab(String numberCN) {
		String tempNumberCN = numberCN;
		// �쳣���ݴ���;
		if (tempNumberCN == null) {
			return 0;
		}
		/*
		 * nums[0] ������ǧ��λ; nums[1] ��������λ; nums[2] �������ڵ�λ;
		 */
		String[] nums = new String[bigUnits.length + 1];
		// ǧλ����,ֱ�Ӵ���;
		nums[0] = tempNumberCN;
		/*
		 * 
		 * �ָ������,��ǧΪ��λ��������;
		 */
		for (int i = (bigUnits.length - 1); i >= 0; i--) {
			// �Ƿ���ڴ�λ(��,��...);
			int find = tempNumberCN.indexOf(bigUnits[i]);
			if (find != -1) {
				String[] tempStrs = tempNumberCN.split(bigUnits[i]);
				// ���ǧλ����;
				if (nums[0] != null) {
					nums[0] = null;
				}
				if (tempStrs[0] != null) {
					nums[i + 1] = tempStrs[0];
				}
				if (tempStrs.length > 1) {
					tempNumberCN = tempStrs[1];
					if (i == 0) {
						nums[0] = tempStrs[1];
					}
				} else {
					tempNumberCN = null;
					break;
				}
			}
		}
		String tempResultNum = "";
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != null) {
				tempResultNum += numberKCN2Arab(nums[i]);
			} else {
				tempResultNum += "0000";
			}
		}
		return Long.parseLong(tempResultNum);
	}

	// ��һλ��������ת��Ϊһλ����
	public static int numberCharCN2Arab(char onlyCNNumber) {
		if (numChars[0] == onlyCNNumber) {
			return 1;
		} else if (numChars[1] == onlyCNNumber || onlyCNNumber == '��') {// ��������ϰ���÷�(��,��)
			return 2;
		} else if (numChars[2] == onlyCNNumber) {
			return 3;
		} else if (numChars[3] == onlyCNNumber) {
			return 4;
		} else if (numChars[4] == onlyCNNumber) {
			return 5;
		} else if (numChars[5] == onlyCNNumber) {
			return 6;
		} else if (numChars[6] == onlyCNNumber) {
			return 7;
		} else if (numChars[7] == onlyCNNumber) {
			return 8;
		} else if (numChars[8] == onlyCNNumber) {
			return 9;
		}
		return 0;
	}

	// ����ǧ������������,����4λ�����ַ���,λ��������"0"����;
	private static String numberKCN2Arab(String numberCN) {

		if ("".equals(numberCN)) {
			return "";
		}
		int[] nums = new int[4];
		if (numberCN != null) {
			for (int i = 0; i < units.length; i++) {
				int idx = numberCN.indexOf(units[i]);
				if (idx > 0) {
					char tempNumChar = numberCN.charAt(idx - 1);
					int tempNumInt = numberCharCN2Arab(tempNumChar);
					nums[i] = tempNumInt;
				}
			}
			// ����ʮλ
			char ones = numberCN.charAt(numberCN.length() - 1);
			nums[nums.length - 1] = numberCharCN2Arab(ones);
			// �����λ
			if ((numberCN.length() == 2 || numberCN.length() == 1)
					&& numberCN.charAt(0) == 'ʮ') {
				nums[nums.length - 2] = 1;
			}
		}
		// ���ؽ��
		String tempNum = "";
		for (int i = 0; i < nums.length; i++) {
			tempNum += nums[i];
		}
		return (tempNum);
	}

	/* ������������������ʵ����ĿҪ��Ĺ��� */
	/* ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^ */
	/****************************** ��ʼд���� ******************************/
	static long transfer(String str) {
		return numberCN2Arab(str);
	}

	/****************************** ����д���� ******************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long res;
		String _str;
		try {
			_str = in.nextLine();
		} catch (Exception e) {
			_str = null;
		}

		res = transfer(_str);
		System.out.println(String.valueOf(res));

	}
}
