package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
	public static void main(String[] args) {
		List<? extends Fruit> flist = new ArrayList<Fruit>();

		flist.add(new Fruit());
	}
}
