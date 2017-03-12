import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(7, 1, 7,
				7, 61, 61, 61, 10, 10, 10, 61));
		new Solution().majorityNumber(nums, 3);
	}

}
