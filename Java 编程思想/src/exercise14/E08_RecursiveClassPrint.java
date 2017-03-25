package exercise14;

import static net.mindview.util.Print.print;
import typeinfo.pets.Pug;

/**
 * ʹ�÷����ȡĳ����ļ̳���ϵ
 * 
 * @author pfjia
 *
 */
public class E08_RecursiveClassPrint {
	public static void printClasses(Class<?> c) {
		if (c == null) {
			return;
		}
		print(c.getName());
		for (Class<?> k : c.getInterfaces()) {
			print("Interface: " + k.getName());
			printClasses(k.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}

	public static void main(String[] args) {
		printClasses(Pug.class);
	}
}
