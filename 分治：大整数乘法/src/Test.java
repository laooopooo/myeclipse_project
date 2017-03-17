import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		char[] c1 = "123456789".toCharArray();
		char[] c2 = "1".toCharArray();
		char[] result = s.multi(c1, c2);
		System.out.println(Arrays.toString(result));
	}

}
