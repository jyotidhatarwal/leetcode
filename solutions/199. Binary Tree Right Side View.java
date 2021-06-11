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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
     List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode>que = new LinkedList<>();
        que.add(root);
        while(que.size() > 0){
            int size = que.size();
            ans.add(que.getFirst().val);
            while(size-- > 0){
                TreeNode rem = que.removeFirst();
                if(rem.right != null){
                    que.add(rem.right);
                }
                if(rem.left != null){
                    que.add(rem.left);
                }
            }
        }
        return ans;
    }
}
