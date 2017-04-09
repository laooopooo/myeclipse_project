import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Solution {
	/**
	 * @param n
	 *            : An integer
	 * @return: An integer
	 */

	// 朴素递归算法----超时
	// public int climbStairs(int n) {
	// // write your code here
	// if (n == 1) {
	// return 1;
	// }
	// if (n == 2) {
	// return 2;
	// }
	// return climbStairs(n - 1) + climbStairs(n - 2);
	// }

	// // 备忘录----超时
	// public int climbStairs2(int n) {
	// int[] r = new int[n + 1];
	//
	// for (int i = 0; i < r.length; i++) {
	// r[i] = Integer.MIN_VALUE;
	// }
	// return memoClimbStairs(n, r);
	//
	// }
	//
	// public int memoClimbStairs(int n, int[] r) {
	// int result = 0;
	// if (r[n] > 0) {
	// return r[n];
	// }
	// if (n == 1) {
	// result = 1;
	// } else if (n == 2) {
	// result = 2;
	// } else {
	// result = memoClimbStairs(n - 1, r) + memoClimbStairs(n - 2, r);
	// }
	// r[n] = result;
	// return result;
	// }

	// 自底向上
	// 把climbStairs从0~n-1的结果都存放起来
	public static long climbStairs(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		// 索引为0的位置不存放值
		long[] r = new long[n + 1];
		// 初始化边界
		r[1] = 1;
		r[2] = 2;

		for (int i = 3; i <= n; i++) {
			r[i] = r[i - 1] + r[i - 2];
		}
		return r[n];
	}

	// 需要读取文件的路径
	private static String fileReadName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// 需要写入文件的路径
	private static String fileWriteName = "C:\\Users\\Administrator\\Desktop\\2.txt";

	// 使用Scanner读取文件
	public static Scanner createScanner() {
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

	// 使用BufferedWrite写文件
	public static BufferedWriter createWrite()
			throws UnsupportedEncodingException {
		File file = new File(fileWriteName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("success create file,the file is "
					+ fileWriteName);
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

	public static void main(String[] args) throws IOException {
		Scanner sc = createScanner();
		BufferedWriter bw = createWrite();
		int maxNum = sc.nextInt();
		for (int i = 1; i < maxNum; i++) {
			int n = sc.nextInt();
			bw.write(climbStairs(n) + "\n");
		}
		bw.write(climbStairs(maxNum) + "");
		bw.close();

	}
}