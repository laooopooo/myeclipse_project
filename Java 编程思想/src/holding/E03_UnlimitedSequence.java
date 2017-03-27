package holding;

import innerclasses.Selector;

import java.util.ArrayList;
import java.util.List;

class UnlimitedSequence {
	private final List<Object> items = new ArrayList<Object>();

	public void add(Object o) {
		items.add(o);
	}

	public Selector selector() {
		return new SequenceSelector();
	}

	private class SequenceSelector implements Selector {
		private int i;

		@Override
		public boolean end() {
			// TODO Auto-generated method stub
			return i == items.size();
		}

		@Override
		public Object current() {
			// TODO Auto-generated method stub
			return items.get(i);
		}

		@Override
		public void next() {
			// TODO Auto-generated method stub
			if (i < items.size()) {
				i++;
			}
		}

	}
}

public class E03_UnlimitedSequence {

	public static void main(String[] args) {
		UnlimitedSequence sequence = new UnlimitedSequence();
		for (int i = 0; i < 10; i++) {
			sequence.add(i);
		}
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + "  ");
			selector.next();
		}
	}
}
