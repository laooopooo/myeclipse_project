
public class Main {
	public static void main(String[] args) {
		ListNode head=new ListNode(0);
		Solution s=new Solution();
		ListNode l=s.reverse(head);
		while(l!=null){
			System.out.println(l.val);
			l=l.next;
		}
	}
}
