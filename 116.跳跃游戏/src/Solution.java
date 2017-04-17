public class Solution {
	/**
	 * @param A
	 *            : A list of integers
	 * @return: The boolean answer
	 */
	public boolean canJump(int[] A) {
		// wirte your code here
		int currMaxStep = A[0]; // 当前能够跳跃的最大步数
		int step = 0;
		for (int i = 1; i < A.length; ++i) {
			if (i > currMaxStep)
				return false;
			currMaxStep = max(i + A[i], currMaxStep);
			if (currMaxStep >= A.length - 1)
				return true;
		}
		return currMaxStep >= A.length - 1;
	}

	private int max(int i, int currMaxStep) {
		// TODO Auto-generated method stub
		return i > currMaxStep ? i : currMaxStep;
	}

}
