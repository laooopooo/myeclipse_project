import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class Solution {
	/**
	 * 思路: 1.如果n 为奇数可以转化为 (a^(n/2) * a^(n/2) * a ) %b = ((a^(n/2)%b *
	 * a^(n/2)%b)%b * a%b) %b 2. 如果n 为偶数可以转化为 (a^(n/2) * a^(n/2) ) %b =
	 * (a^(n/2)%b * a^(n/2)%b)%b /
	 * 
	 */
	/**
	 * 
	 * @param a
	 *            , b, n: 32bit integers
	 * @return: An integer
	 */
	public static int fastPower(int a, int b, int n) {
		// write your code here
		// 递归退出条件
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return a % b;
		}
		int temp = fastPower(a, b, n / 2);
		if ((n & 1) == 1) {// 如果n是奇数
			return ((temp * temp) % b * a % b) % b;
		}
		// 如果n是偶数
		else {
			return (temp * temp) % b;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = createScanner(fileReadName);
		BufferedWriter bw = createWrite(fileWriteName);
		int testNums = sc.nextInt();
		for (int i = 0; i < testNums - 1; i++) {
			int a = sc.nextInt();
			int n = sc.nextInt();
			int b = sc.nextInt();
			int result = fastPower(a, b, n);
			bw.write(result + "\n");
		}
		int a = sc.nextInt();
		int n = sc.nextInt();
		int b = sc.nextInt();
		int result = fastPower(a, b, n);
		bw.write(result + "");
		bw.close();
	}

	public static Scanner createScanner(String fileReadName) {
		Scanner sc = null;
		File file = new File(fileReadName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("success read file,the file is " + fileReadName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sc;
	}

	public static BufferedWriter createWrite(String fileWriteName)
			throws UnsupportedEncodingException {
		File file = new File(fileWriteName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out
					.println("success open file,the file is " + fileWriteName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, false)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bw;
	}

	// 需要读取文件的路径
	private static String fileReadName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// 需要写入文件的路径
	private static String fileWriteName = "C:\\Users\\Administrator\\Desktop\\2.txt";
};