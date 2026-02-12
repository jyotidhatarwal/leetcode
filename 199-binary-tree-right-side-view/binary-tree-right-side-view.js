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
 * @return {number[]}
 */
var rightSideView = function(root) {
    let ans = [];
    let queue = [root];
    if(!root) return ans;
    while(queue.length){
        let levelSize = queue.length;
        for(let i=0;i<levelSize;i++){
            let curr = queue.shift();
            if(i === 0){
                // only need to add the first element fo each level in ans
                ans.push(curr.val);
            }
            curr.right && queue.push(curr.right);
            curr.left && queue.push(curr.left);
        }
    }
    return ans;
};