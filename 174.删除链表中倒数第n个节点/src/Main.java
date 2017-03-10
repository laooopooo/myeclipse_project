public class Main {
	public static void main(String[] args) {
		int a = 1;
		ListNode l1 = new Solution().intToListNode(a);

		ListNode l2 = new Solution().removeNthFromEnd(l1, 1);

		while (l2 != null) {
			System.out.println(l2.val + "  ");
			l2 = l2.next;
		}

	}
}
