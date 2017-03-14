public class Test {
	public static void main(String[] args) {
		int[] i = new int[] { 1, 2 };
		ListNode head = ListNode.tailInsert(i);
		ListNode.displayListNodes(head);
		new Solution().reorderList(head);
		ListNode.displayListNodes(head);
	}
}
