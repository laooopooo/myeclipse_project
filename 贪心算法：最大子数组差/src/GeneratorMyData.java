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
		DataWriter dw = new DataWriter(fileName);

		dw.write(testCase + "\n");
		for (int i = 0; i < testCase - 1; i++) {
			int length = r.nextInt(220) + 20;
			dw.write(length + "\n");
			dw.writeUnorderedIntegers(length, 200, -200);
			dw.write("\n");

		}
		int length = r.nextInt(220) + 20;
		dw.write(length + "\n");
		dw.writeUnorderedIntegers(length, 200, -200);
		dw.close();

	}
}
