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
 
    
    // -1 i am covered by a camera .
    // 0 i am a camera.
    // 1 means i need a camera.
class Solution{
    int camera=0;
    public int minCameraCover(TreeNode root) {
        if(minCameraCover_(root) == 1) camera++;
        return camera;
    }
    
    public int minCameraCover_(TreeNode root){
        if(root==null) return  -1;
        
        int lres = minCameraCover_(root.left);
        int rres = minCameraCover_(root.right);
​
        if(lres == 1 || rres == 1){
            camera++;
            return 0;
        }
​
        if(lres == 0 || rres == 0){
            return -1;
        }
​
        return 1;
    }
    
}
