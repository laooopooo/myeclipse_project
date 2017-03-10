/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {
	/**
	 * @param head
	 *            : The first node of linked list.
	 * @return: True if it has a cycle, or false
	 */
	public boolean hasCycle(ListNode head) {
		// write your code here
		if (head == null) {
			return false;
		}
		ListNode now = head;
		ListNode bianli = head;
		// 循环遍历，查看当前元素是否和以前出现的元素一样
		while (now != null) {
			bianli=head;
			if(now.next==now){
				return true;
			}
			while (bianli != now) {
				if (now.next == bianli) {
					return true;
				}
				bianli = bianli.next;
			}
			now = now.next;
		}
		return false;
	}
}
