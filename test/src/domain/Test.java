package domain;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		// List<Character> l = new ArrayList<Character>(Arrays.asList('1', '2',
		// '3', '4'));
		// System.out.println(l);
		// List<Character> l2 = new ArrayList<Character>(l);
		// System.out.println(l2);

		Object[] os = new Object[1];
		os[0] = "1";
		Object[] os = new Object[1];
		os[0] = "2";
		String[] ss = new String[1];
		ss[0] = (String) os[0];

	ss = (String[]) os;

	}
}
