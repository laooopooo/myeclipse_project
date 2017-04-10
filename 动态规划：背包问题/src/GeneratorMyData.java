import java.io.IOException;
import java.util.Random;

public class GeneratorMyData {
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
		DataWriter dw = new DataWriter(fileName);

		dw.write(testCase + "\n");
		for (int i = 0; i < testCase - 1; i++) {
			backPackCapacity = r.nextInt(500) + 10;
			goodNum = backPackCapacity / 5;

			dw.write(backPackCapacity + "\n");
			dw.write(goodNum + " ");

			dw.writeUnorderedDatas(goodNum, backPackCapacity / 2,
					backPackCapacity / 15);
			dw.write("\n");
		}
		backPackCapacity = r.nextInt(500) + 10;
		goodNum = backPackCapacity / 5;

		dw.write(backPackCapacity + "\n");
		dw.write(goodNum + " ");

		dw.writeUnorderedDatas(goodNum, backPackCapacity / 2,
				backPackCapacity / 15);
		dw.close();

	}
}
