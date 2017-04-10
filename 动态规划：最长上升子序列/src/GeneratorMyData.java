import java.io.IOException;
import java.util.Random;

public class GeneratorMyData {
	private static Random r = new Random(47);

	// 文件路径
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";

	public static void main(String[] args) throws IOException {
		// 测试用例数
		int testCase = 100;
		// 序列长度
		int num = 0;
		DataWriter dw = new DataWriter(fileName);

		dw.write(testCase + "\n");
		for (int i = 0; i < testCase - 1; i++) {
			num = r.nextInt(1000) + 10;
			dw.write(num + "\n");
			dw.writeUnorderedDatas(num, 1000, -1000);
			dw.write("\n");
		}
		num = r.nextInt(1000) + 10;
		dw.write(num + "\n");
		dw.writeUnorderedDatas(num, 1000, -1000);
		dw.close();

	}
}
