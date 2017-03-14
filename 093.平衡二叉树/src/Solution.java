/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
	/**
	 * 思路：
	 * 分治法：1.问题分解 （1）左子树是不是平衡树（2）右子树是不是平衡树
	 * 2.问题求解 递归求解
	 * 3.问题合并 （1）左右子树有一个不是平衡树，则树不是平衡树
	 * （2）左右子树都是平衡树，根据左右子树的深度判断树是不是平衡树
	 * 
	 */
	
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
    	if(root==null){
    		return true;
    	}
    	//问题分解
    	if(root.left!=null){
    		if(!isBalanced(root.left)){
    			return false;
    		}
    	}
    	if(root.right!=null){
    		if(!isBalanced(root.right)){
    			return false;
    		}
    	}
    	
    	//判断两颗子树深度之差是否有2
    	int leftDepth=0;
    	int rightDepth=0;
    	if(root.left!=null){
    		leftDepth=maxDepth(root.left);
    	}
    	if(root.right!=null){
    		rightDepth=maxDepth(root.right);
    	}
    	int cha=rightDepth-leftDepth;
    	if(cha>=2||cha<=-2){
    		return false;
    	}
    	return true;
    	
    	//
    	
    }
    
    
    public int maxDepth(TreeNode root) {
        // write your code here
    	if(root==null){
    		return 0;
    	}
    	
    	int leftDepth=0;
    	int rightDepth=0;
    	if(root.left!=null){
    		leftDepth=maxDepth(root.left);
    	}
    	if(root.right!=null){
    		rightDepth=maxDepth(root.right);
    	}
    	if(rightDepth>leftDepth){
    		return rightDepth+1;
    	}else{
    		return leftDepth+1;
    	}
    }
}