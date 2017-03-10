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

	public ListNode reverseBetween(ListNode head, int m, int n) {
		// write your code here

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode now = dummy;
		// 使now指向第m-1个节点，即需要翻转节点的前一个节点
		for (int i = 0; i < m - 1; i++) {
			now = now.next;
		}

		ListNode temp = null;
		ListNode lastNode = now.next;
		ListNode insertNode = now.next.next;
		// 从第m+1个节点使用头插法建链表
		for (int i = 0; i < n - m; i++) {

			temp = insertNode;

			insertNode = insertNode.next;

			temp.next = now.next;
			now.next = temp;

		}
		lastNode.next = insertNode;

		return dummy.next;
	}
}