/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {
	/**
	 * @param head
	 *            : The head of linked list.
	 * @return: The new head of reversed linked list.
	 */
	public ListNode reverse(ListNode head) {
		// write your code here
		// 头插法建链表
		ListNode dummy = new ListNode(0);
		ListNode now = dummy;
		ListNode temp = null;
		while (head != null) {
			temp = head;

			head = head.next;

			temp.next = now.next;
			now.next = temp;

		}
		return dummy.next;
	}
}