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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return help(preorder,0,n-1,inorder,0,n-1);
    }
     private TreeNode help(int[] preorder,int psi,int pei, int[] inorder,int isi,int iei){
         if(isi > iei) return null;
         
         TreeNode node = new TreeNode();
         node.val = preorder[psi];
         
         int idx = isi;
         while(inorder[idx] != preorder[psi]) idx++;
         int count = idx - isi;
         
         node.left = help(preorder,psi+1,psi+count,inorder,isi,idx-1);
         node.right = help(preorder,psi+count+1,pei,inorder,idx+1,iei);
         return node;
     }
}
