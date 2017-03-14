public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public static ListNode tailInsert(int[] nums) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode temp;
		for (int i = 0; i < nums.length; i++) {
			temp = new ListNode(nums[i]);
			tail.next = temp;
			tail = tail.next;
		}
		return dummy.next;
	}

	public static ListNode headInsert(int[] nums) {
		ListNode dummy = new ListNode(0);
		ListNode temp;
		for (int i = 0; i < nums.length; i++) {
			temp = new ListNode(nums[i]);
			temp.next = dummy.next;
			dummy.next = temp.next;
		}
		return dummy.next;
	}

	public static void displayListNodes(ListNode head) {
		if (head == null) {
			System.out.println("ListNodeÎª¿Õ!");
		} else {
			System.out.println("ListNodeÎª£º");
			while (head != null) {
				System.out.print(head.val + "  ");
				head = head.next;
			}
			System.out.println();
		}
	}
}