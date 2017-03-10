/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {
	/**
	 * @param ListNode
	 *            l1 is the head of the linked list
	 * @param ListNode
	 *            l2 is the head of the linked list
	 * @return: ListNode head of linked list
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// write your code here
		ListNode dummy1 = new ListNode(0);
		dummy1.next = l1;
		ListNode dummy2 = new ListNode(0);
		dummy2.next = l2;

		ListNode i = dummy1;
		ListNode j = dummy2;
		ListNode temp = null;

		// 把l2插入l1中
		while (i.next != null && j.next != null) {
			if (j.next.val > i.next.val) {
				// l2中元素大于l1
				// 找到合适的位置，将l2中元素插入进去
				while (i.next!=null&&i.next.val < j.next.val) {
					i = i.next;
				}
				//当l2中元素都大于l1中时
				if(i.next==null){
					i.next=j.next;
					return dummy1.next;
				}

				temp = j.next;
				j.next = j.next.next;
				temp.next = i.next;
				i.next = temp;

				// 更新i，j
				i=i.next;
			} else {
				// l1中元素大于l2
				// 将l2插入到前面
				temp = j.next;
				j.next = j.next.next;
				temp.next = i.next;
				i.next = temp;

				// 更新i，j
				i = i.next;
			}
		}
//l1若为空，则返回l2
		if(dummy1.next==null){
			return dummy2.next;
		}
		return dummy1.next;
	}
	
	//头插法建链表
	public ListNode headInsert(int[] s){
		ListNode dummy=new ListNode(0);
		ListNode now=dummy;
		for(int i=0;i<s.length;i++){
			now.next=new ListNode(s[i]);
			now=now.next;
		}
		return dummy.next;
		
	}
}