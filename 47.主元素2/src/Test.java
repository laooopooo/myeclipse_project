import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 1, 1,
				1, 2, 2, 3, 3, 4, 4, 4));
		new Solution().majorityNumber(nums);
	}

}
