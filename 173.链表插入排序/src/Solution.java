/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
    	//判断head是否为空
    	if(head==null){
    		return head;
    	}
    	
    	//头结点
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	//一个标志位，判断是否执行了插入操作
    	boolean insert;
    	
    	//n个数需要循环n-1次，所以从链表的第二个数开始循环
    	ListNode i=dummy.next;
    	ListNode j=null;
    	while(i.next!=null){
    		//标志位复位
    		insert=false;
    		//把j复位
    		j=dummy;
    		while(j!=i){
    			//j和i进行比较
    			if(i.next.val<j.next.val){
    				//小则插入，大则不变
    				ListNode temp=i.next;
    				i.next=i.next.next;
    				temp.next=j.next;
    				j.next=temp;
    				insert=true;
    				break;
    			}
    			//j移后一位
    			j=j.next;
    		}
    		//如果没有插入操作，i移后一位
    		if(!insert){
        		i=i.next;
    		}
    	}
    	
    	return dummy.next;
    }
}