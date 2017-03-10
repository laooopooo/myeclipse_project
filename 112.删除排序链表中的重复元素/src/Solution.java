/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
    	ListNode dummy=new ListNode(Integer.MAX_VALUE);
    	dummy.next=head;
    	ListNode before=dummy;
    	ListNode after=before.next;
    	while(before!=null&&after!=null){
    		if(after.val==before.val){
    			before.next=after.next;
    			after=before.next;
    		}else{
    			before=before.next;
    			after=after.next;
    		}
    	}
    	return dummy.next;
    }  
}