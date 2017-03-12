import java.util.ArrayList;

public class Solution {
	/**
	 * @param nums
	 *            : a list of integers
	 * @return: find a majority number
	 */
	public int majorityNumber(ArrayList<Integer> nums) {
		// write your code
		// 主元素
		int majority = Integer.MAX_VALUE;
		// 主元素的次数
		int numTime = 0;
		for (int i = 0; i < nums.size(); i++) {
			// 遍历的元素与主元素一致,元素个数加一
			if (majority == nums.get(i)) {
				numTime++;
			}
			// 遍历的元素与主元素不一致，判断此时主元素的次数
			else if (numTime > 0) {// 主元素次数大于1，主元素次数减1
				numTime--;
			} else if (numTime == 0) {// 主元素次数等于0，更改主元素
				majority = nums.get(i);
				numTime++;
			}

		}

		return majority;
	}
}