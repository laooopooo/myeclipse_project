public class Solution {
	/**
	 * @param n
	 *            : An integer
	 * @return: An integer
	 */

	// 朴素递归算法----超时
	// public int climbStairs(int n) {
	// // write your code here
	// if (n == 1) {
	// return 1;
	// }
	// if (n == 2) {
	// return 2;
	// }
	// return climbStairs(n - 1) + climbStairs(n - 2);
	// }

	// // 备忘录----超时
	// public int climbStairs2(int n) {
	// int[] r = new int[n + 1];
	//
	// for (int i = 0; i < r.length; i++) {
	// r[i] = Integer.MIN_VALUE;
	// }
	// return memoClimbStairs(n, r);
	//
	// }
	//
	// public int memoClimbStairs(int n, int[] r) {
	// int result = 0;
	// if (r[n] > 0) {
	// return r[n];
	// }
	// if (n == 1) {
	// result = 1;
	// } else if (n == 2) {
	// result = 2;
	// } else {
	// result = memoClimbStairs(n - 1, r) + memoClimbStairs(n - 2, r);
	// }
	// r[n] = result;
	// return result;
	// }

	// 自底向上
	// 把climbStairs从0~n-1的结果都存放起来
	public int climbStairs(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		// 索引为0的位置不存放值
		int[] r = new int[n + 1];
		// 初始化边界
		r[1] = 1;
		r[2] = 2;

		for (int i = 3; i <= n; i++) {
			r[i] = r[i - 1] + r[i - 2];
		}
		return r[n];
	}
}