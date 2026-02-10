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
    let queue = [p,q];
    while(queue.length){
        let p1 = queue.shift();
        let p2 = queue.shift();
        // leaf node
        if(!p1 && !p2) continue;
        if(!p1 || !p2) return false;
        if(p1.val !== p2.val){
            return false;
        }
        queue.push(p1.left,p2.left);
        queue.push(p1.right,p2.right);
    }
    return true;
};