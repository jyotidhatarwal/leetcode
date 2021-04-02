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
    private int idx =0;
    private TreeNode preorderHelp(int[] preorder,int lr, int rr){
        if(idx >= preorder.length || preorder[idx] < lr || preorder[idx] > rr) return null;
        TreeNode node = new TreeNode(preorder[idx++]);
        node.left = preorderHelp(preorder,lr,node.val);
        node.right = preorderHelp(preorder,node.val,rr);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int lr = 1;
        int rr = (int)1e8 +1;
        return preorderHelp(preorder,lr,rr);
    }
}
