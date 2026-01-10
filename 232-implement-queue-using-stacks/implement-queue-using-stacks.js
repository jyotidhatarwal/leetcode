
var MyQueue = function() {
    this.s1 = [];
    this.s2 = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.s1.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    /* if the s2 is empty then for n elements in the s1, 
    remove the elements from s1 and add to s2,
    and then remove the top element in s2
    and if s2 is not empty just remove the top element
    */
    let n = this.s1.length;
    let ans;
    if(this.s2.length === 0){
        for(let i=0;i<n;i++){
            let element = this.s1.pop();
            this.s2.push(element);
        }
        ans = this.s2.pop();
    }else{
        ans = this.s2.pop();
    }
    return ans;
    
    
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    // same as pop, just do not remove the element from s2
    let n = this.s1.length;
    let ans;
    if(this.s2.length === 0){
        for(let i=0;i<n;i++){
            let element = this.s1.pop();
            this.s2.push(element);
        }
        ans = this.s2[this.s2.length-1];
    }else{
        ans = this.s2[this.s2.length-1];
    }
    return ans;
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    let n1 = this.s1.length;
    let n2 = this.s2.length;
    if(n1 === 0 && n2 === 0) return true;
    return false;
    
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */