import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public char[] reverse(char[] input) {
		char[] output = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = input[input.length - 1 - i];
		}
		return output;
	}

	public NumDividEqual partition(char[] input) {
		return new NumDividEqual(input);
	}

	public int calLength(char[] num1, char[] num2) {
		int len = num1.length > num2.length ? num1.length : num2.length;
		if (len == 1)
			return 1;
		len += len & 1;
		return len;
	}

	public static char[] trimPrefix(char[] input) {
		char[] ret = null;
		for (int i = 0; i < input.length; i++) {
			if (ret == null && input[i] == '0')
				continue;
			else {
				if (ret == null) {
					ret = new char[input.length - i];
				}
				ret[i - (input.length - ret.length)] = input[i];
			}
		}
		if (ret == null)
			return new char[] { '0' };
		return ret;
	}

	public static char[] format(char[] input, int n) {
		if (input.length >= n) {
			return input;
		}
		char[] ret = new char[n];
		for (int i = 0; i < n - input.length; i++) {
			ret[i] = '0';
		}
		for (int i = 0; i < input.length; i++) {
			ret[n - input.length + i] = input[i];
		}
		return ret;
	}

	public char[] addTail(char[] input, int n) {
		char[] ret = new char[input.length + n];
		for (int i = 0; i < input.length; i++) {
			ret[i] = input[i];
		}
		for (int i = input.length; i < ret.length; i++) {
			ret[i] = '0';
		}
		return ret;
	}

	public char[] add(char[] num1, char[] num2) {
		int len = num2.length > num1.length ? num2.length : num1.length;
		int carry = 0;
		num1 = format(num1, len);
		num2 = format(num2, len);
		char[] ret = new char[len + 1];

		for (int i = len - 1; i >= 0; i--) {
			int tmp = num1[i] + num2[i] - 96;
			tmp += carry;
			if (tmp >= 10) {
				carry = 1;
				tmp = tmp - 10;
			} else {
				carry = 0;
			}
			ret[len - i - 1] = (char) (tmp + 48);
		}
		ret[len] = (char) (carry + 48);
		return trimPrefix(reverse(ret));
	}

	public static char[] sub(char[] num1, char[] num2) {
		int lenMax = num1.length > num2.length ? num1.length : num2.length;
		char[] newNum1 = Arrays.copyOf(format(num1, lenMax), lenMax);
		char[] newNum2 = Arrays.copyOf(format(num2, lenMax), lenMax);

		for (int i = 0; i < lenMax; i++) {
			if ((newNum1[i] == '0' && newNum1[i] == '0')
					|| newNum1[i] == newNum2[i]) {
				continue;
			} else if (newNum1[i] < newNum2[i]) {
				System.out
						.println("The Parameter in sub(A,B).A MUST Bigger Than B!");
				System.exit(0);
			} else
				break;
		}

		for (int i = lenMax - 1; i >= 0; i--) {
			if (newNum1[i] < newNum2[i]) {
				newNum1[i] = (char) (newNum1[i] + '0' + 10 - newNum2[i]);
				newNum1[i - 1] = (char) (newNum1[i - 1] - 1);
			} else {
				newNum1[i] = (char) (newNum1[i] + '0' - newNum2[i]);
			}
		}
		return trimPrefix(newNum1);
	}

	public char[] mult(char[] num1, char[] num2) {
		char[] A, B, C, D, AC, BD, AjB, CjD, ACjBD, AjBcCjD, SUM;
		int N = calLength(num1, num2);
		num1 = format(num1, N);
		num2 = format(num2, N);
		if (num1.length > 1) {
			NumDividEqual nu1 = partition(num1);
			NumDividEqual nu2 = partition(num2);
			A = nu1.A;
			B = nu1.B;
			C = nu2.A;
			D = nu2.B;
			AC = mult(A, C);
			BD = mult(B, D);
			AjB = add(A, B);
			CjD = add(C, D);
			ACjBD = add(AC, BD);
			AjBcCjD = mult(AjB, CjD);

			char[] tmp1 = addTail(sub(AjBcCjD, ACjBD), N / 2);
			char[] tmp2 = add(addTail(AC, N), BD);
			SUM = add(tmp1, tmp2);
			char[] test = trimPrefix(SUM);
			return test;
		} else {
			Integer ret = (num1[0] - 48) * (num2[0] - 48);
			return ret.toString().toCharArray();
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Main bg = new Main();
		int dataNums = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < dataNums - 1; i++) {
			char[] num1 = sc.nextLine().toCharArray();
			char[] num2 = sc.nextLine().toCharArray();
			char[] ret = bg.mult(num1, num2);
			String result = String.valueOf(ret);
			System.out.print(result + "\n");
		}
		char[] num1 = sc.nextLine().toCharArray();
		char[] num2 = sc.nextLine().toCharArray();
		char[] ret = bg.mult(num1, num2);
		String result = String.valueOf(ret);
		System.out.print(result);
	}
}
