public class NumDividEqual {
	public char[] A;
	public char[] B;
	int n;

	/**
	 * ���������Ϊ���ݣ��ֱ��������A������B�У�
	 * 
	 * @param input
	 */
	public NumDividEqual(char[] input) {
		n = input.length / 2;
		A = new char[n];
		B = new char[n];
		for (int i = 0; i < n; i++) {
			A[i] = input[i];
		}
		for (int i = 0; i < n; i++) {
			B[i] = input[i + n];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}