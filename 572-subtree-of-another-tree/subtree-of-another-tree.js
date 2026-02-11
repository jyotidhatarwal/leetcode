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
 * @param {TreeNode} subRoot
 * @return {boolean}
 */
var isSubtree = function(root, subRoot) {
    let hashRoot = serialize(root);
    let hashSubRoot = serialize(subRoot);

   // find if hashsubroot is a substring of hasroot
   // in interview use KMP algorithm
   return hashRoot.includes(hashSubRoot);
};

function serialize (root){
    let hash = "";

    function traversal(curr){
        if(!curr){
            hash += "-#"
            return;
        }
        hash += "-" + curr.val;
        traversal(curr.left);
        traversal(curr.right);
    }
    traversal(root);
    return hash;
}