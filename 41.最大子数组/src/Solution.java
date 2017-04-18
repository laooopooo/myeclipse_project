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
			// ��sum<0��˵������һ��������������֮��С��0������һ�����������ֵ�Ѿ�����¼
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