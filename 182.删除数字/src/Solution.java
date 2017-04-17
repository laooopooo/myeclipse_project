public class Solution {
	/**
	 * @param A
	 *            : A positive integer which has N digits, A is a string.
	 * @param k
	 *            : Remove k digits.
	 * @return: A string
	 */
	public String DeleteDigits(String A, int k) {
		// write your code here
		StringBuffer sb = new StringBuffer(A);
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < sb.length(); j++) {
				if (j == sb.length() - 1 || j + 1 < sb.length()
						&& sb.charAt(j) > sb.charAt(j + 1)) {
					sb.deleteCharAt(j);
					break;
				}
			}
		}
		if (sb.length() == 0) {
			return "0";
		}
		boolean allZero = true;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != '0') {
				allZero = false;
				break;
			}
		}
		if (allZero) {
			return "0";
		}

		int index = 0;
		while (sb.charAt(index) == '0') {
			index++;
		}
		return sb.toString().substring(index);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String a = "107";
		System.out.println(s.DeleteDigits(a, 3));
	}
}