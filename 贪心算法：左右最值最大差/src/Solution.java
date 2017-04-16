public class Solution {
	public int findMaxGap(int[] A, int n) {
		// write code here
		int max = getMax(A);
		int anotherMax = A[0] > A[n - 1] ? A[n - 1] : A[0];
		return max - anotherMax;
	}

	public int getMax(int[] A) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			result = result > A[i] ? result : A[i];
		}
		return result;
	}
}
