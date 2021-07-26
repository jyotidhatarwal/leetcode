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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        addAllLeftMostNode(root,st);
        while(st.size() > 0){
            TreeNode rem = st.pop();
            ans.add(rem.val);
            addAllLeftMostNode(rem.right,st);
        }
        return ans;
        
    }
    private void addAllLeftMostNode(TreeNode root,Stack<TreeNode> st){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
}
