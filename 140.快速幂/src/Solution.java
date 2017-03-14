class Solution {
	/**
	 * 思路: 1.如果n 为奇数可以转化为 (a^(n/2) * a^(n/2) * a ) %b = ((a^(n/2)%b *
	 * a^(n/2)%b)%b * a%b) %b 2. 如果n 为偶数可以转化为 (a^(n/2) * a^(n/2) ) %b =
	 * (a^(n/2)%b * a^(n/2)%b)%b /
	 * 
	 */
	/**
	 * 
	 * @param a
	 *            , b, n: 32bit integers
	 * @return: An integer
	 */
	public int fastPower(int a, int b, int n) {
		// write your code here
		// 递归退出条件
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return a % b;
		}
		int temp = fastPower(a, b, n / 2);
		if ((n & 1) == 1) {// 如果n是奇数
			return ((temp * temp) % b * a % b) % b;
		}
		// 如果n是偶数
		else {
			return (temp * temp) % b;
		}
	}
};