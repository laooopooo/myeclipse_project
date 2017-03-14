/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {

	/**
	 * 思路1：循环n/2次，每次找到最后一个节点，并把其插入到前面，head指向应该插入位置的前一个节点，利用beforeTail找到尾部倒数第二个元素
	 * ，把最后一个元素插入前面后还有把beforeTail的next置null
	 * 分析：上述思路有两次循环，时间复杂度是o(n2)，而且当head和beforeTail同时指向一个元素时
	 * ，插入操作会失败，想要成功还需一个判断（增加一个tail应该就没问题了）
	 */
	/**
	 * 思路2：就是先将链表整体一分为二，然后将后半段链表逆序，再依次插入前半段节点中。
	 * 我们知道利用快慢指针的思想很容易能够找到链表中的中间节点；链表逆序可以采用前插法，O(n)即可解决。所以该题目的总体时间复杂度为O(n)。
	 */
	/**
	 * @param head
	 *            : The head of linked list.
	 * @return: void
	 */
	public void reorderList(ListNode head) {
		// write your code here
		// 判断是否为空或者只有一个节点
		if (head == null || head.next == null) {
			return;
		}
		// 找到链表中间节点
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}// slow指向中间节点

		// 后半段节点逆序
		ListNode nextMid = slow.next;
		if (nextMid == null) {
			return;
		}
		while (nextMid.next != null) {
			ListNode needHeadInsert = nextMid.next;
			nextMid.next = needHeadInsert.next;

			needHeadInsert.next = slow.next;
			slow.next = needHeadInsert;

		}

		// 把逆序后的节点插入到前面
		ListNode now = head;
		while (slow.next != null) {
			ListNode needInsert = slow.next;
			slow.next = needInsert.next;
			needInsert.next = now.next;
			now.next = needInsert;
			// 更新now
			now = needInsert.next;
		}

	}
}