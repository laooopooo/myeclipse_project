import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	private static Set<Long> set = new HashSet<Long>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long l;
		while ((l = sc.nextLong()) != 0) {
			set.add(l);
		}
		System.out.println(set.size());
	}

}
