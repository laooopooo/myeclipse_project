public class Solution {
	// 备忘数组为静态
	private static int[] memo;

	public int shortestStep(int[] a) {
		// 初始化备忘
		memo = new int[a.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Integer.MAX_VALUE;
		}
		return aux(a, a.length - 1);
	}

	// 走到index需要的最短步数
	public int aux(int[] a, int index) {
		// 检查备忘是否已经存在
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
		// 寻找index之前能一步到达index的位置
		for (int i = index - 1; i >= 0; i--) {
			if (a[i] >= (index - i)) {
				int tempStep = aux(a, i) + 1;
				shortestStep = shortestStep > tempStep ? tempStep
						: shortestStep;
			}
		}

		// 更新备忘
		memo[index] = shortestStep;
		return shortestStep;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = new int[] { 3, 1, 1, 1, 3, 1, 1, 1, 2 };
		System.out.println(s.shortestStep(a));
	}

}
