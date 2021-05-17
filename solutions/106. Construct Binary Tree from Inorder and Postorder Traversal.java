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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return help(inorder,0,n-1,postorder,0,n-1);
    }
    
    private TreeNode help(int[] inorder,int isi,int iei, int[] postorder,int psi,int pei){
        if(isi > iei) return null;
        TreeNode node = new TreeNode();
        node.val = postorder[pei];
        int idx = isi;
        while(inorder[idx] != postorder[pei]) idx++;
        int count = idx - isi;
        
        node.left = help(inorder,isi,idx-1,postorder,psi,psi+count-1);
        node.right = help(inorder,idx+1,iei,postorder,psi+count, pei-1);
        return node;
    }
}
