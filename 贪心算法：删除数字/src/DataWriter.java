import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 封装BufferedWriter 添加了两个方法: 1.writeUnorderredDatas() 2.writeOrderedDatas()
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
			// true是追加模式
			// false是重写模式
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, false)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bw;
	}

	/**
	 * 向文件中追加无序元素，没有/n
	 * 
	 * @param fileName
	 * @param length
	 * @param maxNum
	 * @param minNum
	 * @throws IOException
	 */
	public void writeUnorderedIntegers(int length, int maxNum, int minNum) {
		try {
			bw.write(dg.getUnorderedIntegers(length, maxNum, minNum));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向文件中追加有序元素,没有/n
	 * 
	 * @param fileName
	 * @param length
	 * @param maxNum
	 * @param minNum
	 * @throws IOException
	 */
	public void writeOrderedIntegers(int length, int maxNum, int minNum) {
		try {
			bw.write(dg.getOrderedIntegers(length, maxNum, minNum));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向文件中写无序字符串，没有\n
	 * 
	 * @param length
	 */
	public void writeUnorderedString(int length) {
		try {
			bw.write(dg.getUnorderedString(length));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeUnorderedString(int length, char[] chars) {
		try {
			bw.write(dg.getUnorderedString(length, chars));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 向文件中写有序字符串，没有\n
	 * 
	 * @param length
	 */
	public void writeOrderedString(int length) {
		try {
			bw.write(dg.getOrderedString(length));
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
