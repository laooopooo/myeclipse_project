
public class Main {
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] i1={4,4,9,15,20,27,32,32};
		int[] i2={12,13,14,25,26,37,38};
		ListNode l1=s.headInsert(i1);
		ListNode l2=s.headInsert(i2);
		
		ListNode l=s.mergeTwoLists(l1, l2);
		
		while(l!=null){
			System.out.print(l.val+"  ");
			l=l.next;
		}
	}

}
