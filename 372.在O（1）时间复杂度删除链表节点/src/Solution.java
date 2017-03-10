/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
public class Solution {
	/**
	 * @param node
	 *            : the node in the list should be deleted
	 * @return: nothing
	 */
	public void deleteNode(ListNode node) {
		// write your code here
		if(node==null){
			return;
		}else if(node.next==null){
			node=null;
			return;
		}
		// 删除next而不是node, 因为没有prev节点的信息所以复制next到node然后删除next就相当于删掉了node
		ListNode next=node.next;
		node.val=next.val;
		node.next=node.next.next;
	}
}