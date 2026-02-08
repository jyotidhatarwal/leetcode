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
 * @return {number[][]}
 */
var levelOrder = function(root) {
    let res = [];
    let queue = [root];
    if(!root) return res;

    while(queue.length){
        let levelArr = [];
        let levelSize = queue.length;
        for(let i=0;i<levelSize;i++){
            let curr = queue.shift();
            curr.left && queue.push(curr.left);
            curr.right && queue.push(curr.right);
            levelArr.push(curr.val);
        }
        res.push(levelArr);
    }
    return res;
};