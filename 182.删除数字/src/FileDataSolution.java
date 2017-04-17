import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileDataSolution {
	private static String inputFileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	private static String outputFileName = "C:\\Users\\Administrator\\Desktop\\2.txt";
	private static Scanner sc;
	private static BufferedWriter bw;
	static {
		try {
			sc = new Scanner(new File(inputFileName));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outputFileName, false)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String DeleteDigits(String A, int k) {
		// write your code here
		StringBuffer sb = new StringBuffer(A);
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < sb.length(); j++) {
				if (j == sb.length() - 1 || j + 1 < sb.length()
						&& sb.charAt(j) > sb.charAt(j + 1)) {
					sb.deleteCharAt(j);
					break;
				}
			}
		}
		if (sb.length() == 0) {
			return "0";
		}
		boolean allZero = true;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != '0') {
				allZero = false;
				break;
			}
		}
		if (allZero) {
			return "0";
		}

		int index = 0;
		while (sb.charAt(index) == '0') {
			index++;
		}
		return sb.toString().substring(index);
	}

	public static void main(String[] args) throws IOException {
		FileDataSolution fds = new FileDataSolution();
		int testCase = sc.nextInt();
		String s1;
		int k;
		// s1 =
		// "rEpvTqgnNdziwuXZoGyMbwuEvEeYNzQJLfHteGhMPgiOSRHkWCtqkPDxUmjTeIVUQQBXSGDWypCwTKeXGZbBEpmHbovMDdxAZHDyfXIsrJSqGEZZlASjjuzRHbVZgFxpDUhgQwqQyQHSvAabDffbJNnYFXygWNAgFWqjbCZrGLdreMvMDKupWGlkYgmPbwuxIXwGHUPUTMklSjrCmdfaRaFMeeNdEfngoVRxEnKIjcckRmPDDspIIInVTRSiSJwQgRukCCRLrGss";
		// s2 =
		// "EWVCxRIAcDaYNAUVBkPkErsUxKDHdUppgqjmRAvWMgyELKvJnXECllHUZzspmsSUMNDbDAmQRSsKDJDiukwexzfzHiBTrLaCPAxgTbpEOohJrJsCmKItSMypQkzUShdQtmImkDMZIXVJhWGQMxPbiXyWvkyZBubqLrBMEJXvmpobzUugDdbnGDlqhetxpdNgEbLDqIbywgpjXWrFjfShClmUZnRVSjafFLgaBzWCmbdIWJkNhKsuORFurOCkoUpFdWWSPNqHinXS";
		// System.out.println(fds.longestCommonSubsequence(s1, s2));
		for (int i = 0; i < testCase - 1; i++) {
			// 初始化数据
			s1 = sc.next();
			k = sc.nextInt();
			bw.write(fds.DeleteDigits(s1, k) + "\n");
		}
		// 初始化数据

		s1 = sc.next();
		k = sc.nextInt();
		bw.write(fds.DeleteDigits(s1, k) + "");
		bw.close();

	}
}
