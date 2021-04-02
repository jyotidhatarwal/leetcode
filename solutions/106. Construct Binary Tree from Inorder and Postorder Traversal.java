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
    public TreeNode buildTreeHelp(int[] inorder,int isi,int iei,int[] postorder,int psi,int pei){
        if(isi > iei) return null;
        int idx = isi;
        while(inorder[idx] != postorder[pei]) idx++;
        int tnoe = idx -isi;
        TreeNode node = new TreeNode(postorder[pei]);
        node.left  = buildTreeHelp(inorder,isi,idx-1,postorder,psi,psi + tnoe -1);
        node.right = buildTreeHelp(inorder,idx+1,iei,postorder,psi + tnoe,pei-1);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        return buildTreeHelp(inorder,0,n-1,postorder,0,n-1);
    }
}
