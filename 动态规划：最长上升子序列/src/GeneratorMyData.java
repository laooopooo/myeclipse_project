import java.io.IOException;
import java.util.Random;

public class GeneratorMyData {
	private static Random r = new Random(47);

	// �ļ�·��
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";

	public static void main(String[] args) throws IOException {
		// ����������
		int testCase = 100;
		// ���г���
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
