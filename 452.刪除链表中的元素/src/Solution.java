/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	/**
	 * @param head
	 *            a ListNode
	 * @param val
	 *            an integer
	 * @return a ListNode
	 */
	public ListNode removeElements(ListNode head, int val) {
		// Write your code here
		// 无头结点删除指定元素
		// 确保头结点的元素不是val，此时head可能是null
		while (head != null && head.val == val) {
			head = head.next;
		}
		// 一个now，一个before保证可以删除
		ListNode now = null;
		ListNode before = head;
		while (before != null) {
			now = before.next;

			// 判断now是不是将要删除的元素
			// now不空，且可删除
			if (now != null && now.val == val) {
				before.next = now.next;
			} else if (now == null) {// now为空
				before = now;
			} else {// now不空且不删除
				before = now;
			}
		}
		return head;
	}
}