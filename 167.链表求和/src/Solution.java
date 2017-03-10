/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	/**
	 * @param l1
	 *            : the first list
	 * @param l2
	 *            : the second list
	 * @return: the sum list of l1 and l2
	 */
	public ListNode addLists(ListNode l1, ListNode l2) {
		// write your code here

		// 头结点，无意义
		ListNode head = new ListNode(0);
		ListNode now = head;
		// 计算整数和，再将其换为链表
		// 上面的方法不行，因为有
		// 9->9->9->9->9->9->9->9->9->9->9->9->9->9->9
		// ->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->
		// 9->9->9->9->9->9->9->9->9->9->9->9->null,
		// 9->9->9->9->9->9->9->9->9->9->9->9->9->9->9
		// ->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->9->
		// 9->9->9->9->9->9->9->9->9->9->9->9->null这样的输入,我服了

		int jinwei = 0;
		int tempResult = 0;

		// 两个整数只要有一个不为空就继续循环
		while (l1 != null || l2 != null) {
			// l1的两种情况
			if (l1 != null) {
				if (l2 != null) {
					// l1,l2都不为空
					tempResult = jinwei + l1.val + l2.val;
					if (tempResult > 9) {
						jinwei = tempResult / 10;
						now.next = new ListNode(tempResult % 10);
					} else {
						jinwei=0;
						now.next = new ListNode(tempResult);
					}
					l2 = l2.next;
				} else {
					tempResult = jinwei + l1.val;
					if (tempResult > 9) {
						jinwei = tempResult / 10;
						now.next = new ListNode(tempResult % 10);
					} else {
						jinwei=0;
						now.next = new ListNode(tempResult);
					}
				}
				l1 = l1.next;
			} else {
				// l1为空，则l2必不为空
				tempResult = jinwei + l2.val;
				if (tempResult > 9) {
					jinwei = tempResult / 10;
					now.next = new ListNode(tempResult % 10);
				} else {
					jinwei=0;
					now.next = new ListNode(tempResult);
				}
				l2 = l2.next;
			}
			now = now.next;
		}
		if(jinwei!=0){
			now.next=new ListNode(jinwei);
		}
		return head.next;
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
