import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class MyData {
	private static Random r = new Random(47);

	// 文件路径
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// 生成100组测试用例
	private static int TESTCASENUMS = 100;

	// 背包大小的范
	// 可选物品个数

	// 可选物品大小

	public static void main(String[] args) throws IOException {
		int testCase = 100;
		int backPackCapacity = 0;
		int goodNum = 0;
		int goodWeight = 0;
		BufferedWriter bf = DataGenerator.createWrite(fileName);
		bf.write(testCase + "\n");
		for (int i = 0; i < testCase - 1; i++) {
			backPackCapacity = r.nextInt(500) + 10;
			goodNum = backPackCapacity / 5;
			bf.write(backPackCapacity + "\n");
			bf.write(goodNum + " ");
			for (int j = 0; j < goodNum - 1; j++) {
				goodWeight = r.nextInt(backPackCapacity / 2) + backPackCapacity
						/ 15;
				bf.write(goodWeight + " ");
			}
			goodWeight = r.nextInt(backPackCapacity / 2);
			bf.write(goodWeight + "");
			bf.write("\n");
		}
		backPackCapacity = r.nextInt(500) + 10;
		goodNum = backPackCapacity / 5;
		bf.write(backPackCapacity + "\n");
		bf.write(goodNum + " ");
		for (int j = 0; j < goodNum - 1; j++) {
			goodWeight = r.nextInt(backPackCapacity / 2) + backPackCapacity
					/ 15;
			bf.write(goodWeight + " ");
		}
		goodWeight = r.nextInt(backPackCapacity / 2);
		bf.write(goodWeight + "");
		bf.close();

	}
}
