import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class MyData {
	private static Random r = new Random();

	// �ļ�·��
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// �ж���������
	private static int DATANUMS = 500;
	// ÿ�����ݵķ�Χ
	private static int MAXLENGTH = 200;

	public static void main(String[] args) throws IOException {
		int dataNums = DATANUMS;
		BufferedWriter bw = DataGenerator.createWrite(fileName);
		bw.write(dataNums + "");
		for (int i = 0; i < dataNums; i++) {
			// ÿ������������
			for (int j = 0; j < 2; j++) {
				bw.write("\n");
				Random r = new Random();
				int length = r.nextInt(MAXLENGTH);
				// ��һλ������0�������г���
				bw.write(r.nextInt(8) + 1 + "");
				for (int k = 0; k < length; k++) {
					int num = r.nextInt(10);
					bw.write(num + "");
				}
			}
		}
		DataGenerator.close();

	}
}
