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
	 * 分治法：１．问题分解　左右两子树是不是查找树
	 * ２．问题求解　递归
	 * ３．问题合并　（１）左右子树有一个不是查找树，则不是查找树（２）都是查找树，判断左右节点的值
	 */
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
    	if(root==null){
    		return true;
    	}
    	
    	if(root.left!=null){
    		if(root.left.val>root.val||!isValidBST(root.left)){
    			return false;
    		}
    	}
    	if(root.right!=null){
    		if(root.right.val<root.val||!isValidBST(root.right)){
    			return false;
    		}
    	}
    	
    	return true;
    }
}