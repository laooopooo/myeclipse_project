package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 2);
		map.put(2, 3);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>(map);
		System.out.println(m);


	}
}
