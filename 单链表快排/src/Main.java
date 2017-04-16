import java.util.Scanner;

public class Main {

	/* ������������������ʵ����ĿҪ��Ĺ��� */
	/* ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^ */
	/****************************** ��ʼд���� ******************************/
	static String quickSortInputOutput(String str) {
		LinkList list = stringToLinkList(str);
		quickSort(list.head, list.tail);
		StringBuilder sb = new StringBuilder();
		Node temp = list.head;
		while (temp != null) {
			sb.append(temp.data);
			sb.append(",");
			temp = temp.next;
		}
		sb.delete(sb.length() - 1, sb.length());
		return sb.toString();
	}

	static void quickSort(Node begin, Node end) {
		if (begin != end) {
			Node partion = getPartion(begin, end);
			quickSort(begin, partion);
			if (partion.next != null) {
				quickSort(partion.next, end);
			}
		}
	}

	static Node getPartion(Node begin, Node end) {
		int data = begin.data;
		Node p = begin;
		Node q = p.next;

		while (q != end.next) {
			if (q.data < data) {
				p = p.next;
				swap(p, q);
			}
			q = q.next;
		}

		swap(p, begin);
		return p;
	}

	static void swap(Node p, Node q) {
		int data = p.data;
		p.data = q.data;
		q.data = data;
	}

	// �������strװ��ΪLinkList
	static LinkList stringToLinkList(String str) {
		String[] strs = str.split(",");
		int[] ints = new int[strs.length];
		// ��strװ��Ϊint
		for (int i = 0; i < ints.length; i++) {
			ints[i] = Integer.valueOf(strs[i]);
		}

		// ����Node
		Node dummy = new Node(0, null);
		Node tail = dummy;
		Node temp = null;

		for (int i = 0; i < ints.length; i++) {
			temp = new Node(ints[i], null);
			tail.next = temp;
			tail = temp;
		}
		LinkList list = new LinkList(dummy.next, tail);
		return list;
	}

	/****************************** ����д���� ******************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String res;

		String _str;
		try {
			_str = in.nextLine();
		} catch (Exception e) {
			_str = null;
		}

		res = quickSortInputOutput(_str);
		System.out.println(res);
	}
}

class Node {
	public int data;
	public Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

class LinkList {
	public Node head;
	public Node tail;

	public LinkList(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	}

}
