public class Solution {

	/**
	 * @param m
	 *            : An integer m denotes the size of a backpack
	 * @param A
	 *            : Given n items with size A[i]
	 * @return: The maximum size
	 */
	public int backPack(int m, int[] A) {
		// write your code here
		/**
		 * 初始化备忘数组 备忘数组的维数与子问题的参数有关,几个参数就是几维 当前子问题的参数有两个 1.背包剩余空间
		 * 2.可选的物品数（使用可选物品的最大index代表）
		 */
		int memo[][] = new int[m + 1][A.length + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < A.length + 1; j++) {
				memo[i][j] = -1;
			}
		}
		return memoSubBackPackAux(m, A, A.length - 1, memo);
	}

	/**
	 * 子问题中 “背包大小”、“可选物品数目”改变，所以这两个是参数， 需要根据物品数组判断每个物品的大小
	 * 
	 * @param m
	 *            背包剩余空间
	 * @param A
	 *            物品数组
	 * @param num
	 *            可选物品个数，从0~num都可选(初始num是数组长度-1)
	 * @param memo
	 *            备忘数组
	 * @return
	 */
	public int memoSubBackPackAux(int m, int[] A, int num, int[][] memo) {
		int result = 0;
		// 备忘录中已存在相应值
		if (memo[m][num] != -1) {
			return memo[m][num];
		}
		// 边界条件,可选物品只有一个
		if (num == 0) {
			// 背包剩余空间可以装下最后一个物品
			if (m >= A[num]) {
				result = A[num];
			}
			// 背包剩余空间装不下最后一个物品
			else {

				result = 0;
			}
		}
		// 分解为子问题
		else if (m >= A[num]) {// 背包剩余空间足够装下当前物品
			// 考虑两种情况，取最大值
			result = max(memoSubBackPackAux(m, A, num - 1, memo),
					(A[num] + memoSubBackPackAux(m - A[num], A, num - 1, memo)));
		} else {// 背包剩余空间足够装下当前物品
			// 仅考虑不装的情况
			result = memoSubBackPackAux(m, A, num - 1, memo);
		}
		// 更新备忘
		memo[m][num] = result;
		return result;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = { 2, 3, 5, 7 };
		int i = s.backPack(11, A);
		System.out.println(i);
	}
}
