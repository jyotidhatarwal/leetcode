/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return construct(nums,0,n-1);
    }
    private TreeNode construct(int[]inorder,int si,int ei){
         if(si > ei) return null;
        
        int mid = (si + ei) /2;
        TreeNode node = new TreeNode(inorder[mid]);
        node.left = construct(inorder,si,mid-1);
        node.right = construct(inorder,mid+1,ei);
        return node;
    }
}
