/**
 * @param {string} s
 * @return {string}
 */
var removeOuterParentheses = function(s) {
    /* 
    If ( -> push in the stack
    if ) -> pop from stack
    and check the length of stack if 1 then ignore that element
    if length of stack > 1 then add that element to ans string
     */
    let stack = [];
    let n = s.length;
    let ans = "";
    for(let i=0;i<s.length;i++){
        if(s[i] === '('){
            stack.push(s[i]);
            if(stack.length !== 1){
                ans += s[i];
            }
        }else{
             if(stack.length !== 1){
                ans += s[i];
            }
             stack.pop();
        }
    }
    return ans;
};