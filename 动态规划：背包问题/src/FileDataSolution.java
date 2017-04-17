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

	public int longestCommonSubsequence(String A, String B) {
		// write your code here
		if (A == null || B == null || A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int aLen = A.length();
		int bLen = B.length();
		int[][] memo = new int[aLen + 1][bLen + 1];
		// ��memo���г�ʼ��
		for (int i = 0; i < memo.length; i++) {
			memo[i][0] = 0;
		}
		for (int i = 0; i < memo[0].length; i++) {
			memo[0][i] = 0;
		}
		for (int i = 1; i < memo.length; i++) {
			for (int j = 1; j < memo[0].length; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					memo[i][j] = memo[i - 1][j - 1] + 1;
				} else {
					memo[i][j] = memo[i][j - 1] > memo[i - 1][j] ? memo[i][j - 1]
							: memo[i - 1][j];
				}
			}
		}
		int maxLength = 0;
		// ����memo���ҵ���󳤶�
		for (int i = 1; i < memo.length; i++) {
			for (int j = 1; j < memo[0].length; j++) {
				maxLength = maxLength > memo[i][j] ? maxLength : memo[i][j];
			}
		}
		return maxLength;
	}

	public static void main(String[] args) throws IOException {
		FileDataSolution fds = new FileDataSolution();
		int testCase = sc.nextInt();
		String s1;
		String s2;
		// s1 =
		// "rEpvTqgnNdziwuXZoGyMbwuEvEeYNzQJLfHteGhMPgiOSRHkWCtqkPDxUmjTeIVUQQBXSGDWypCwTKeXGZbBEpmHbovMDdxAZHDyfXIsrJSqGEZZlASjjuzRHbVZgFxpDUhgQwqQyQHSvAabDffbJNnYFXygWNAgFWqjbCZrGLdreMvMDKupWGlkYgmPbwuxIXwGHUPUTMklSjrCmdfaRaFMeeNdEfngoVRxEnKIjcckRmPDDspIIInVTRSiSJwQgRukCCRLrGss";
		// s2 =
		// "EWVCxRIAcDaYNAUVBkPkErsUxKDHdUppgqjmRAvWMgyELKvJnXECllHUZzspmsSUMNDbDAmQRSsKDJDiukwexzfzHiBTrLaCPAxgTbpEOohJrJsCmKItSMypQkzUShdQtmImkDMZIXVJhWGQMxPbiXyWvkyZBubqLrBMEJXvmpobzUugDdbnGDlqhetxpdNgEbLDqIbywgpjXWrFjfShClmUZnRVSjafFLgaBzWCmbdIWJkNhKsuORFurOCkoUpFdWWSPNqHinXS";
		// System.out.println(fds.longestCommonSubsequence(s1, s2));
		for (int i = 0; i < testCase - 1; i++) {
			// ��ʼ������
			s1 = sc.next();
			s2 = sc.next();
			bw.write(fds.longestCommonSubsequence(s1, s2) + "\n");
		}
		// ��ʼ������
		s1 = sc.next();
		s2 = sc.next();

		bw.write(fds.longestCommonSubsequence(s1, s2) + "");
		bw.close();

	}
}
