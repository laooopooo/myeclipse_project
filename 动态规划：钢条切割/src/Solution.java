public class Solution {

	/**
	 * 
	 * @param p
	 *            �±��1��ʼ�ĸ����۸��
	 * @param n
	 *            �����ĸ����ĳ���
	 * @return �����۸��͸����ĳ��ȣ��ָ�������������
	 */
	public static int cutRod(int[] p, int n) {
		if (n == 0) {
			return 0;
		}

		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			result = max(result, p[i] + cutRod(p, n - i));
		}
		return result;
	}

	/**
	 * ������¼���Զ����·�
	 * 
	 * @param p
	 *            �±��1��ʼ�ĸ����۸��
	 * @param n
	 *            �����ĸ�������
	 * @return
	 */

	public static int memoizedCutRod(int[] p, int n) {
		// ��ʼ����������
		int[] r = new int[p.length];
		for (int i = 0; i < r.length; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		return memoizedCutRodAux(p, n, r);
	}

	/**
	 * �����˱�������
	 * 
	 * @param p
	 * @param n
	 * @param r
	 * @return
	 */
	public static int memoizedCutRodAux(int[] p, int n, int[] r) {
		int result;
		// ���ұ�������
		if (r[n] >= 0) {
			return r[n];
		}

		if (n == 0) {
			result = 0;
		} else {
			result = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++) {
				result = max(result, p[i] + memoizedCutRodAux(p, n - i, r));
			}
		}

		// ���±�������
		r[n] = result;
		return result;

	}

	public static int boottomUpCutRod(int[] p, int n) {
		int[] r = new int[p.length];
		r[0] = 0;

		int result;

		for (int j = 1; j <= n; j++) {
			result = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i++) {
				result = max(result, p[i] + r[j - i]);
			}
			r[j] = result;
		}

		return r[n];
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		int[] prices = new int[] { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		long startTime;
		long endTime;
		startTime = System.nanoTime();
		for (int i = 1; i <= 10; i++) {
			System.out.println("����Ϊ" + i + "���������Ϊ��" + cutRod(prices, i));
		}
		endTime = System.nanoTime();
		System.out.println("����ʱ��Ϊ��" + (endTime - startTime) + "ns");
		System.out.println("==========================================");
		startTime = System.nanoTime();
		for (int i = 1; i <= 10; i++) {
			System.out.println("����Ϊ" + i + "���������Ϊ��"
					+ memoizedCutRod(prices, i));
		}
		endTime = System.nanoTime();
		System.out.println("����ʱ��Ϊ��" + (endTime - startTime) + "ns");

	}
}
