import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class MyData {
	private static Random r = new Random();

	// 文件路径
	private static String fileName = "C:\\Users\\Administrator\\Desktop\\1.txt";
	// 有序元素个数
	private static int DATANUMS = 6000;
	// 有元素的范围
	private static int MINNUM = -(int) (DATANUMS * (r.nextFloat() * 1.5 + 1));
	private static int MAXNUM = (int) (DATANUMS * (r.nextFloat() * .5 + 1));

	// 搜索元素个数(是元素个数的2-4.5倍)
	private static int SEARCHNUMS = (int) (DATANUMS * (r.nextFloat() * 2.5 + 2));
	// 搜索元素的范围
	private static int MINSEARCHNUM = (int) (MINNUM * (r.nextFloat() * 1 + 1));
	private static int MAXSEARCHNUM = (int) (MAXNUM * (r.nextFloat() * 1 + 2));

	public static void main(String[] args) throws IOException {
		int dataNums = DATANUMS;
		int searchNums = SEARCHNUMS;
		BufferedWriter bw = DataGenerator.createWrite(fileName);
		bw.write(dataNums + "\n");
		DataGenerator.writeOrderedDatas(dataNums, MAXNUM, MINNUM);
		bw.write("\n");
		bw.write(searchNums + "\n");
		DataGenerator.writeOrderedDatas(searchNums, MAXSEARCHNUM, MINSEARCHNUM);
		DataGenerator.close();

	}
}
