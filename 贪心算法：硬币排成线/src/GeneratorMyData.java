import java.io.IOException;

public class GeneratorMyData {

	// �ļ�·��
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";

	public static void main(String[] args) throws IOException {
		// ����������
		int testCase = 300;
		DataWriter dw = new DataWriter(fileName);

		dw.write(testCase + "\n");
		for (int i = 0; i < testCase - 1; i++) {
			dw.write((i + 1) + "");
			dw.write("\n");
		}
		dw.write(testCase + "");
		dw.close();

	}
}
