/**
 * Definition for singly-linked list.
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
    	if(headA==null){
    		return null;
    	}
    	ListNode nowA=headA;
    	ListNode nowB=headB;
    	//遍历A链表，判断有没有元素与B链表中一致
    	while(nowA!=null){
    		nowB=headB;
    		while(nowB!=null){
    			if(nowB==nowA){
    				return nowA;
    			}
    			nowB=nowB.next;
    		}
    		nowA=nowA.next;
    	}
    	return null;
    }  
}