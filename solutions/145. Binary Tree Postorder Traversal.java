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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while(root != null){
            if(root.right == null){
                ans.add(root.val);
                root = root.left;
            }else{
                TreeNode rootp1 = root.right;
                while(rootp1.left != null && rootp1.left != root){
                    rootp1 = rootp1.left;
                }
                if(rootp1.left == null){
                    ans.add(root.val);
                    rootp1.left  = root;
                    root = root.right;
                }else{
                    rootp1.left = null;
                    root = root.left;
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
