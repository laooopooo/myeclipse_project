import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * ��װBufferedWriter �������������: 1.writeUnorderredDatas() 2.writeOrderedDatas()
 * 
 * @author pfjia
 *
 */
public class DataWriter {
	private static DataGenerator dg = new DataGenerator();
	private static BufferedWriter bw = null;

	public DataWriter(String fileName) {
		// TODO Auto-generated constructor stub
		bw = createWrite(fileName);
	}

	public BufferedWriter getBufferedWriter() {
		return bw;
	}

	private BufferedWriter createWrite(String fileName) {
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("success create file,the file is " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// true��׷��ģʽ
			// false����дģʽ
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, false)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bw;
	}

	/**
	 * ���ļ���׷������Ԫ�أ�û��/n
	 * 
	 * @param fileName
	 * @param length
	 * @param maxNum
	 * @param minNum
	 * @throws IOException
	 */
	public void writeUnorderedDatas(int length, int maxNum, int minNum) {
		try {
			bw.write(dg.getUnorderedDatas(length, maxNum, minNum));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ļ���׷������Ԫ��,û��/n
	 * 
	 * @param fileName
	 * @param length
	 * @param maxNum
	 * @param minNum
	 * @throws IOException
	 */
	public void writeOrderedDatas(int length, int maxNum, int minNum) {
		try {
			bw.write(dg.getOrderedDatas(length, maxNum, minNum));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(int c) {
		try {
			bw.write(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(String str) {
		try {
			bw.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(char[] cbuf, int off, int len) {
		try {
			bw.write(cbuf, off, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(String s, int off, int len) {
		try {
			bw.write(s, off, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		// TODO Auto-generated method stub
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
