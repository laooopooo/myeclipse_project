import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class MyData {
	private static Random r = new Random();

	// 文件路径
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// 有多少组数据
	private static int DATANUMS = 500;
	// 每组数据的范围
	private static int MAXLENGTH = 200;

	public static void main(String[] args) throws IOException {
		int dataNums = DATANUMS;
		BufferedWriter bw = DataGenerator.createWrite(fileName);
		bw.write(dataNums + "");
		for (int i = 0; i < dataNums; i++) {
			// 每组数据有两行
			for (int j = 0; j < 2; j++) {
				bw.write("\n");
				Random r = new Random();
				int length = r.nextInt(MAXLENGTH);
				// 第一位不能是0，单独列出来
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
