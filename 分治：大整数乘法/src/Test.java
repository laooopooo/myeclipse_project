public class Test {
	public static void main(String[] args) {
		char[] c1 = "123456789".toCharArray();
		char[] c2 = "654321".toCharArray();
		char[] s = new Solution().add(c1, c2);
		System.out.println(s);
	}

}
