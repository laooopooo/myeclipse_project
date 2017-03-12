import java.util.ArrayList;

public class Solution {

	/**
	 * 思路:
	 * 
	 * 维持两个主元素， 如果遍历的元素与主元素一致，对应主元素个数加1， 如果不一致，判断主元素个数是否为0，是则更新主元素，
	 * 不是，则两个主元素的个数都减1；
	 */
	/**
	 * @param nums
	 *            : A list of integers
	 * @return: The majority number that occurs more than 1/3
	 */
	public int majorityNumber(ArrayList<Integer> nums) {
		// write your code
		// 用二维数组保存两个主元素
		int[][] majority = new int[][] { { Integer.MAX_VALUE, 0 },
				{ Integer.MAX_VALUE, 0 } };
		for (int i = 0; i < nums.size(); i++) {
			boolean flag = false;
			// 判断当前的主元素中是否有值和当前元素相等的
			for (int j = 0; j < majority.length; j++) {
				if (majority[j][0] == nums.get(i)) {
					flag = true;
					break;
				}
			}
			// 如果有相等,则相等加一，另一个不变
			if (flag == true) {
				for (int j = 0; j < majority.length; j++) {
					if (majority[j][0] == nums.get(i)) {
						majority[j][1]++;
					}
				}
			}
			// 如果不相等，则判断两个主元素个数有没有为0
			else {
				boolean isZero = false;
				for (int j = 0; j < majority.length; j++) {
					if (majority[j][1] == 0) {
						isZero = true;
						break;
					}
				}
				// 如果有为0，则更新主元素
				// 因为有同时为0的可能，所以遇到一个0后就break
				if (isZero) {
					for (int j = 0; j < majority.length; j++) {
						if (majority[j][1] == 0) {
							majority[j][0] = nums.get(i);
							majority[j][1] = 1;
							break;
						}
					}
				}
				// 如果不为0,两个主元素个数都减1
				else {
					for (int j = 0; j < majority.length; j++) {
						majority[j][1]--;
					}
				}
			}
		}

		// 数组全部遍历之后，两个主元素中一定有一个真正的主元素，但是不能通过现在主元素次数比较，而是重新遍历，记录真正的元素次数
		// 将元素次数置为0
		for (int j = 0; j < majority.length; j++) {
			majority[j][1] = 0;
		}
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < majority.length; j++) {
				if (nums.get(i) == majority[j][0]) {
					majority[j][1]++;
				}
			}
		}

		// 数组全部遍历之后，两个主元素较大的就是真正的主元素
		if (majority[0][1] > majority[1][1]) {
			return majority[0][0];
		} else {
			return majority[1][0];
		}
	}

}
