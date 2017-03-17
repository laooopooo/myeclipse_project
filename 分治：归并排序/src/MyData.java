import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

//归并数据生成器
public class MyData {
	// 文件路径
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// 共有多少组实验数据
	private static int TESTTIMES = 2;
	// 每组实验数据个数最大值
	private static int MAXTESTNUMS = 5;
	// 随机数的范围
	private static int MINNUM = -1000;
	private static int MAXNUM = 1000;

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = DataGenerator.createWrite(fileName);
		bw.write(TESTTIMES + "");
		Random r = new Random();
		int testTimes = TESTTIMES;
		int testNums;
		for (int i = 0; i < testTimes; i++) {// 生成TESTTIMES组实验数据
			testNums = r.nextInt(MAXTESTNUMS);// 每组实验数据的元素值
			bw.write("\n" + testNums + "\n");
			DataGenerator.writeUnorderedDatas(testNums, MAXNUM, MINNUM);
		}
		bw.close();
	}

}
