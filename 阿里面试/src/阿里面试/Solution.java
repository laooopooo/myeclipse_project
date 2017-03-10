package 阿里面试;

public class Solution {

	/**
	 * 把一个数组分割成两部分，两部分数值之和相等，分割点的数值不计算
	 * 
	 * @param array
	 * @param start
	 *            数组起始位置
	 * @param end
	 *            数组终止位置
	 * @return 若可以分解，返回分割点的index，不可分解，返回-1
	 */
	public int splitToTwo(int[] array, int start, int end) {
		// 第一部分的和，和第二部分的和
		int sun1 = 0;
		int sun2 = 0;
		while (start != end) {
			sun1 += array[start];
			sun2 += array[end];

			if (sun1 < sun2) {

			}
		}
		return start;
	}
}
