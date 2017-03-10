/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	/**
	 * @param head
	 *            a ListNode
	 * @return a ListNode
	 */
	public ListNode swapPairs(ListNode head) {
		// Write your code here
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode now = dummy;
		ListNode temp=now.next;;
		while(now.next!=null&&temp.next!=null){
			now.next=temp.next;
			temp.next=now.next.next;
			now.next.next=temp;
			now=temp;
			temp=now.next;
		}
		return dummy.next;
	}
}