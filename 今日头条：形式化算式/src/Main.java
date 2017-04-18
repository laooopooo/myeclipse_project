import java.text.DecimalFormat;
import java.util.Scanner;

class Number {
	public String s[] = new String[5];

	public Number() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < s.length; i++) {
			s[i] = new String();
		}
	}
}

public class Main {
	private static Number[] num = new Number[10];
	private static Number add = new Number();
	private static Number sub = new Number();
	private static Number mul = new Number();
	private static Number div = new Number();
	private static Number equ = new Number();
	private static Number dot = new Number();
	private static String sss = "***";
	private static String s = "*";
	private static String bbs = "  *";
	private static String sbb = "*  ";
	private static String sbs = "* *";
	private static String bbb = "   ";
	private static String bsb = " * ";
	private static String bbbb = "    ";
	private static String ssss = "****";
	private static String bb = "  ";
	private static String ss = "**";
	static {

		for (int i = 0; i < num.length; i++) {
			num[i] = new Number();
		}
		num[0].s[0] = sss;
		num[0].s[1] = sbs;
		num[0].s[2] = sbs;
		num[0].s[3] = sbs;
		num[0].s[4] = sss;

		num[1].s[0] = s;
		num[1].s[1] = s;
		num[1].s[2] = s;
		num[1].s[3] = s;
		num[1].s[4] = s;

		num[3].s[0] = sss;
		num[3].s[1] = bbs;
		num[3].s[2] = sss;
		num[3].s[3] = bbs;
		num[3].s[4] = sss;

		num[2].s[0] = sss;
		num[2].s[1] = bbs;
		num[2].s[2] = sss;
		num[2].s[3] = sbb;
		num[2].s[4] = sss;

		num[4].s[0] = sbs;
		num[4].s[1] = sbs;
		num[4].s[2] = sss;
		num[4].s[3] = bbs;
		num[4].s[4] = bbs;

		num[5].s[0] = sss;
		num[5].s[1] = sbb;
		num[5].s[2] = sss;
		num[5].s[3] = bbs;
		num[5].s[4] = sss;

		num[6].s[0] = sss;
		num[6].s[1] = sbb;
		num[6].s[2] = sss;
		num[6].s[3] = sbs;
		num[6].s[4] = sss;

		num[7].s[0] = sss;
		num[7].s[1] = bbs;
		num[7].s[2] = bbs;
		num[7].s[3] = bbs;
		num[7].s[4] = bbs;

		num[8].s[0] = sss;
		num[8].s[1] = sbs;
		num[8].s[2] = sss;
		num[8].s[3] = sbs;
		num[8].s[4] = sss;

		num[9].s[0] = sss;
		num[9].s[1] = sbs;
		num[9].s[2] = sss;
		num[9].s[3] = bbs;
		num[9].s[4] = sss;

		add.s[0] = bbb;
		add.s[1] = bsb;
		add.s[2] = sss;
		add.s[3] = bsb;
		add.s[4] = bbb;

		sub.s[0] = bbb;
		sub.s[1] = bbb;
		sub.s[2] = sss;
		sub.s[3] = bbb;
		sub.s[4] = bbb;

		mul.s[0] = bbb;
		mul.s[1] = sbs;
		mul.s[2] = bsb;
		mul.s[3] = sbs;
		mul.s[4] = bbb;

		div.s[0] = bbb;
		div.s[1] = bbs;
		div.s[2] = bsb;
		div.s[3] = sbb;
		div.s[4] = bbb;

		equ.s[0] = bbbb;
		equ.s[1] = ssss;
		equ.s[2] = bbbb;
		equ.s[3] = ssss;
		equ.s[4] = bbbb;

		dot.s[0] = bb;
		dot.s[1] = bb;
		dot.s[2] = bb;
		dot.s[3] = ss;
		dot.s[4] = ss;
	}

	public static String f(String num1, String num2, String ope) {
		DecimalFormat decimalFormat = new DecimalFormat("##0.00");
		float n1 = Float.parseFloat(num1);
		float n2 = Float.parseFloat(num2);
		String result;
		float fResult = 0;
		switch (ope) {
		case "+":
			fResult = n1 + n2;
			break;
		case "-":
			fResult = n1 - n2;
			break;
		case "*":
			fResult = n1 * n2;
			break;
		case "£¯":
			fResult = n1 / n2;
			break;
		}

		// float temp = (float) (Math.round(fResult * 100) / 100);
		// result = String.valueOf(temp);
		result = decimalFormat.format(fResult);
		StringBuilder sb = new StringBuilder(result);
		for (int i = sb.length() - 1; i >= sb.length() - 2; i--) {
			if (sb.charAt(i) == '0') {
				sb.delete(sb.length() - 1, sb.length());
			}
		}
		if (sb.charAt(sb.length() - 1) == '.') {
			sb.delete(sb.length() - 1, sb.length());
		}

		return sb.toString();
	}

	public static Number[] floatToNumber(String n) {
		String ns[] = n.split("");
		Number result[] = new Number[ns.length];
		for (int i = 0; i < ns.length; i++) {
			if (ns[i].equals(".")) {
				result[i] = dot;
			} else {
				int j = Integer.parseInt(ns[i]);
				result[i] = num[j];
			}
		}
		return result;
	}

	public static Number[] numToNumber(String n) {
		String ns[] = n.split("");
		Number result[] = new Number[ns.length];
		for (int i = 0; i < n.length(); i++) {
			int j = Integer.parseInt(ns[i]);
			result[i] = num[j];
		}
		return result;
	}

	public static Number opeToNumber(String ope) {
		switch (ope) {
		case "+":
			return add;
		case "-":
			return sub;
		case "*":
			return mul;
		case "£¯":
			return div;
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		Number[] n1 = numToNumber(num1);
		String ope = sc.next();
		Number op = opeToNumber(ope);
		String num2 = sc.next();
		Number[] n2 = numToNumber(num2);

		// ¼ÆËã½á¹û
		String result = f(num1, num2, ope);
		Number[] nResult = floatToNumber(result);
		StringBuilder[] sb = new StringBuilder[5];

		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder();
		}

		for (int i = 0; i < sb.length; i++) {
			for (int j = 0; j < n1.length; j++) {
				sb[i].append(n1[j].s[i] + "  ");
			}
			sb[i].append(op.s[i] + "  ");
			for (int j = 0; j < n2.length; j++) {
				sb[i].append(n2[j].s[i] + "  ");
			}
			sb[i].append(equ.s[i] + "  ");
			for (int j = 0; j < nResult.length; j++) {
				sb[i].append(nResult[j].s[i] + "  ");
			}

		}

		for (int i = 0; i < 5; i++) {
			System.out.println(sb[i]);
		}
	}
}
