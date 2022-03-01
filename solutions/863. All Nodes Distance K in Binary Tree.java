/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        distanceK(root,target,k,ans);
        return ans;
    }
    private void kdown(TreeNode root,int k,TreeNode blockNode,List<Integer> ans){
        if(root == null || k < 0 || root == blockNode){
            return;
        }
        if(k == 0){
            ans.add(root.val);
            return;
        }
        kdown(root.left,k-1,blockNode,ans);
        kdown(root.right,k-1,blockNode,ans);
    }
    private int distanceK(TreeNode root,TreeNode target,int k,List<Integer> ans){
        if(root == null){
            return -1;
        }
        if(root.val == target.val){
            kdown(root,k-0,null,ans);
            return 1;
        }
        int leftDis = distanceK(root.left,target,k,ans);
        if(leftDis != -1){
            kdown(root,k-leftDis,root.left,ans);
            return leftDis+1;
        }
        int rightDis = distanceK(root.right,target,k,ans);
        if(rightDis != -1){
            kdown(root,k-rightDis,root.right,ans);
            return rightDis+1;
        }
        return -1;
    }
}
