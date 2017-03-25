package innerclasses;

import exercise10.StringWarpper;

interface Selector {
	boolean end();

	Object current();

	void next();
}

public class Sequence {
	private Object[] items;
	private int next = 0;

	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(Object x) {
		if (next < items.length) {
			items[next++] = x;
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}

	private class SequenceSelector implements Selector {
		private int i = 0;

		public Sequence getOuterInstance() {
			return Sequence.this;
		}

		@Override
		public boolean end() {
			// TODO Auto-generated method stub
			return i == items.length;
		}

		@Override
		public Object current() {
			// TODO Auto-generated method stub
			return items[i];
		}

		@Override
		public void next() {
			// TODO Auto-generated method stub
			if (i < items.length) {
				i++;
			}
		}

	}

	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(new StringWarpper());
		}
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + "  ");
			selector.next();
		}
	}
}
