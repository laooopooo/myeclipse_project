class Solution {
	/**
	 * @param n
	 *            : an integer
	 * @return an integer f(n)
	 */
	public int fibonacci(int n) {
		//使用递归时间超过限制
		// write your code here
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			int a = 0;
			int b = 1;
			int c = 0;
			for (int i = 0; i < n - 2; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			return c;
		}
	}
}