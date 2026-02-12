/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var goodNodes = function(root) {
    let goodNodes = 0;
    function traversal(curr,maxSeenSoFar){
        if(curr.val >= maxSeenSoFar){
            // goodNode
            goodNodes++;
        }
        let currMax = Math.max(curr.val, maxSeenSoFar)
        curr.left && traversal(curr.left,currMax);
        curr.right && traversal(curr.right,currMax);
    }
    traversal(root,-Infinity);
    return goodNodes;
};