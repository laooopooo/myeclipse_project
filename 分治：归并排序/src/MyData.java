import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

//�鲢����������
public class MyData {
	// �ļ�·��
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// ���ж�����ʵ������
	private static int TESTTIMES = 2;
	// ÿ��ʵ�����ݸ������ֵ
	private static int MAXTESTNUMS = 5;
	// ������ķ�Χ
	private static int MINNUM = -1000;
	private static int MAXNUM = 1000;

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = DataGenerator.createWrite(fileName);
		bw.write(TESTTIMES + "");
		Random r = new Random();
		int testTimes = TESTTIMES;
		int testNums;
		for (int i = 0; i < testTimes; i++) {// ����TESTTIMES��ʵ������
			testNums = r.nextInt(MAXTESTNUMS);// ÿ��ʵ�����ݵ�Ԫ��ֵ
			bw.write("\n" + testNums + "\n");
			DataGenerator.writeUnorderedDatas(testNums, MAXNUM, MINNUM);
		}
		bw.close();
	}

}
