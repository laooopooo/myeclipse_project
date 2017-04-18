public class Solution {
	/**
	 * @param nums
	 *            : A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public int maxSubArray(int[] nums) {
		// write your code
		int sum = Integer.MIN_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			// 若sum<0，说明在上一段子数组中连加之和小于0，则上一段子数组最大值已经被记录
			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			maxVal = maxVal > sum ? maxVal : sum;
		}
		return maxVal;
	}
}