public class Solution {
	/**
	 * @param nums
	 *            : A list of integers
	 * @return: An integer indicate the value of maximum difference between two
	 *          Subarrays
	 */
	public int maxDiffSubArrays(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		int[] leftMax = new int[len];
		int[] rightMin = new int[len];
		int[] leftMin = new int[len];
		int[] rightMax = new int[len];
		int localMax = 0;
		int globalMax = Integer.MIN_VALUE;
		int localMin = 0;
		int globalMin = Integer.MAX_VALUE;

		for (int i = 0; i < len; i++) {
			localMax = Math.max(localMax + nums[i], nums[i]);
			globalMax = Math.max(localMax, globalMax);
			leftMax[i] = globalMax;

			localMin = Math.min(localMin + nums[i], nums[i]);
			globalMin = Math.min(localMin, globalMin);
			leftMin[i] = globalMin;
		}

		localMin = 0;
		globalMin = Integer.MAX_VALUE;
		localMax = 0;
		globalMax = Integer.MIN_VALUE;
		for (int i = len - 1; i >= 0; i--) {
			localMin = Math.min(localMin + nums[i], nums[i]);
			globalMin = Math.min(localMin, globalMin);
			rightMin[i] = globalMin;

			localMax = Math.max(localMax + nums[i], nums[i]);
			globalMax = Math.max(localMax, globalMax);
			rightMax[i] = globalMax;
		}
		int leftMAX = Integer.MIN_VALUE;
		int rightMAX = Integer.MIN_VALUE;

		for (int i = 0; i < len - 1; i++) {
			leftMAX = Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), leftMAX);
			rightMAX = Math.max(Math.abs(leftMin[i] - rightMax[i + 1]),
					rightMAX);
		}

		return Math.max(leftMAX, rightMAX);
	}
}
