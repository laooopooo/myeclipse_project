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
	 * 思路：利用递归获取左右子树的深度，树的深度等于左右子树深度的最大值加1
	 * 分治法：1.问题分解（1）求左子树深度（2）求右子树深度
	 * 2.问题求解 利用递归求解
	 * 3.问题合并 左右子树深度较大者加1即为树的深度
	 */
	
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
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