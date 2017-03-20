import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

//归并数据生成器
public class MyData {
	// 文件路径
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// 共有多少组实验数据
	private static int TESTTIMES = 1000;
	// 每组实验数据个数最大值
	private static int MAXB = 50;
	// 随机数的范围
	private static int MINNUM = 0;
	private static int MAXNUM = 1000;

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = DataGenerator.createWrite(fileName);
		int testTimes = TESTTIMES;
		bw.write(testTimes + "");
		Random r = new Random();
		int testNums;
		for (int i = 0; i < testTimes; i++) {// 生成TESTTIMES组实验数据
			int a = r.nextInt(MAXNUM - MINNUM) + MINNUM;
			int n = r.nextInt(MAXNUM - MINNUM) + MINNUM;
			int b = r.nextInt(MAXB) + 1;
			bw.write("\n" + a + " ");
			bw.write(n + " ");
			bw.write(b + "");
		}
		bw.close();
	}

}
