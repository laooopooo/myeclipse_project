import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

//�鲢����������
public class MyData {
	// �ļ�·��
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// ���ж�����ʵ������
	private static int TESTTIMES = 1000;
	// ÿ��ʵ�����ݸ������ֵ
	private static int MAXB = 50;
	// ������ķ�Χ
	private static int MINNUM = 0;
	private static int MAXNUM = 1000;

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = DataGenerator.createWrite(fileName);
		int testTimes = TESTTIMES;
		bw.write(testTimes + "");
		Random r = new Random();
		int testNums;
		for (int i = 0; i < testTimes; i++) {// ����TESTTIMES��ʵ������
			int a = r.nextInt(MAXNUM - MINNUM) + MINNUM;
			int n = r.nextInt(MAXNUM - MINNUM) + MINNUM;
			int b = r.nextInt(MAXB) + 1;
			bw.write("\n" + a + " ");
			bw.write(n + " ");
			bw.write(b + "");
		}
		bw.close();
	}

}
