/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {
	/**
	 * 描述：给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。 你应该保留两部分内链表节点原有的相对顺序。
	 * 思路：把所有比x小的节点插入到前面，比x大的或等于的不变
	 */
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @param x
	 *            : an integer
	 * @return: a ListNode
	 */
	public ListNode partition(ListNode head, int x) {
		// write your code here

		// 判断head是否为空
		if (head == null) {
			return head;
		}

		// 头结点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// 一个标志位，判断是否执行了插入操作
		boolean insert;

		ListNode i = dummy;
		ListNode j = dummy;
		while (i.next != null) {
			// 标志位复位
			insert = false;

			// 判断当前节点的值是否大于等于x，是则不变，不是则插入
			if (i.next.val < x) {
				if (i == j) {
					// 如果i==j，也是要插入，但是不做任何插入操作，把i，和j移位即可
					i = i.next;
					j = j.next;
					insert = true;
				} else {

					// 插入
					ListNode temp = i.next;
					i.next = i.next.next;
					temp.next = j.next;
					j.next = temp;
					// j移位
					j = j.next;
					// 更改插入标志
					insert = true;
				}
			}

			// 如果没有插入操作，i移后一位
			if (!insert) {
				i = i.next;
			}
		}
		return dummy.next;
	}

	public ListNode intToListNode(int x) {
		int yushu;
		ListNode head = new ListNode(0);
		ListNode now = head;

		while (x > 0) {
			yushu = x % 10;
			now.next = new ListNode(yushu);
			now = now.next;
			x = x / 10;
		}
		return head.next;
	}
}
