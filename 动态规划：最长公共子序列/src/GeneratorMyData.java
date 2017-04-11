import java.io.IOException;
import java.util.Random;

public class GeneratorMyData {
	private static Random r = new Random(47);

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
			num = r.nextInt(500) + 10;
			dw.writeUnorderedString(num);
			dw.write("\n");
			dw.writeUnorderedString(num);
			dw.write("\n");
		}
		num = r.nextInt(500) + 10;
		dw.writeUnorderedString(num);
		dw.write("\n");
		dw.writeUnorderedString(num);
		dw.close();

	}
}
