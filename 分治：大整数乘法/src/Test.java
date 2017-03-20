public class Test {
	public static void main(String[] args) {
		BigIntMult bg = new BigIntMult();
		char[] c1 = "123456789".toCharArray();
		char[] c2 = "987654321".toCharArray();
		char[] c3 = bg.mult(c1, c2);
		System.out.println(c3);
	}
}
