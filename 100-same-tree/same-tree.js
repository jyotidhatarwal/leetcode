/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function(p, q) {
    
    function same(A,B){
        if(!A && !B) return true; // leaf node
        if(!A || !B) return false;
        return (A.val === B.val && same(A.left,B.left) && same(A.right,B.right));
    }
    return same(p,q);
};