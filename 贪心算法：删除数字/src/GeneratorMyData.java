import java.io.IOException;
import java.util.Random;

public class GeneratorMyData {
	private static Random r = new Random(47);
	private static char[] ints = "01234356789".toCharArray();

	// 文件路径
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";

	public static void main(String[] args) throws IOException {
		// 测试用例数
		int testCase = 300;
		// 序列长度
		int num = 0;
		DataWriter dw = new DataWriter(fileName);

		dw.write(testCase + "\n");
		for (int i = 0; i < testCase - 1; i++) {
			int length = r.nextInt(210) + 20;
			dw.writeUnorderedString(length, ints);

			int k = r.nextInt(length / 2 - length / 3) + length / 3;
			dw.write(" " + k + "");
			dw.write("\n");
		}
		int length = r.nextInt(220) + 1;
		dw.writeUnorderedString(length, ints);
		int k = r.nextInt(length / 2 - length / 3) + length / 3;
		dw.write(" " + k + "");
		dw.close();

	}
}
