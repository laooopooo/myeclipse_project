public class Solution {
	// ��������Ϊ��̬
	private static int[] memo;

	public int shortestStep(int[] a) {
		// ��ʼ������
		memo = new int[a.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Integer.MAX_VALUE;
		}
		return aux(a, a.length - 1);
	}

	// �ߵ�index��Ҫ����̲���
	public int aux(int[] a, int index) {
		// ��鱸���Ƿ��Ѿ�����
		if (memo[index] != Integer.MAX_VALUE) {
			return memo[index];
		}

		if (index == 1) {
			memo[index] = 0;
			return 0;
		}
		if (a[0] >= index) {
			memo[index] = 1;
			return 1;
		}

		int shortestStep = Integer.MAX_VALUE;
		// Ѱ��index֮ǰ��һ������index��λ��
		for (int i = index - 1; i >= 0; i--) {
			if (a[i] >= (index - i)) {
				int tempStep = aux(a, i) + 1;
				shortestStep = shortestStep > tempStep ? tempStep
						: shortestStep;
			}
		}

		// ���±���
		memo[index] = shortestStep;
		return shortestStep;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = new int[] { 3, 1, 1, 1, 3, 1, 1, 1, 2 };
		System.out.println(s.shortestStep(a));
	}

}
