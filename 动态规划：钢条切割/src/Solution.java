public class Solution {

	/**
	 * 
	 * @param p
	 *            下标从1开始的钢条价格表
	 * @param n
	 *            给定的钢条的长度
	 * @return 给定价格表和钢条的长度，分割带来的最大收益
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
	 * 带备忘录的自顶向下法
	 * 
	 * @param p
	 *            下标从1开始的钢条价格表
	 * @param n
	 *            给定的钢条长度
	 * @return
	 */

	public static int memoizedCutRod(int[] p, int n) {
		// 初始化辅助数组
		int[] r = new int[p.length];
		for (int i = 0; i < r.length; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		return memoizedCutRodAux(p, n, r);
	}

	/**
	 * 增加了备忘机制
	 * 
	 * @param p
	 * @param n
	 * @param r
	 * @return
	 */
	public static int memoizedCutRodAux(int[] p, int n, int[] r) {
		int result;
		// 查找备忘数组
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

		// 更新备忘数组
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
			System.out.println("长度为" + i + "的最大收益为：" + cutRod(prices, i));
		}
		endTime = System.nanoTime();
		System.out.println("运行时间为：" + (endTime - startTime) + "ns");
		System.out.println("==========================================");
		startTime = System.nanoTime();
		for (int i = 1; i <= 10; i++) {
			System.out.println("长度为" + i + "的最大收益为："
					+ memoizedCutRod(prices, i));
		}
		endTime = System.nanoTime();
		System.out.println("运行时间为：" + (endTime - startTime) + "ns");

	}
}
