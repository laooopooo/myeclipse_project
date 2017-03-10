public class Main {
	public static void main(String[] args) {
		Solution s=new Solution();
		int i=42133;
		ListNode l1=s.intToListNode(i);
		
		ListNode l2=s.partition(l1, 3);
		
		while(l2!=null){
			System.out.println(l2.val+"  ");
			l2=l2.next;
		}

	}
}
