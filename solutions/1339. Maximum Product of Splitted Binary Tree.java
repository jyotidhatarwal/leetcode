class Solution {
    long sum; // Total sum of binary tree
    long max=0; // Max Product
    public int maxProduct(TreeNode root) {
        sum=dfs(root); // 1st pass to find total sum and sum of subtrees
        solve(root);  // 2nd pass to find the max product of sum of nodes of subtrees
        return (int)(max%1000000007);
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        // store sum of nodes of every subtree recursively
        return root.val = root.val+dfs(root.left)+dfs(root.right); 
    }
    public void solve(TreeNode root){
        if(root==null) return;
        // update max product if trees had to be split from current node
        max=Math.max(max,root.val*(sum-root.val)); 
        solve(root.left);
        solve(root.right);
    }
}
