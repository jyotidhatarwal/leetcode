
var MyStack = function() {
    this.q1 = [];
    this.q2 = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MyStack.prototype.push = function(x) {
    this.q1.push(x);
};

/**
 * @return {number}
 */
MyStack.prototype.pop = function() {
    /* remove n-1 elements from q1 and push them to q2,
     and then remove the last element in q1 
    and exchange(swap) q1 and q2 
    and return the last element removed from q1*/
    let n = this.q1.length;
    for(let i=0;i<n-1;i++){
        let firstElement = this.q1.shift();
        this.q2.push(firstElement);
    }
    let lastElement = this.q1.shift();
    let temp = this.q1;
    this.q1 = this.q2;
    this.q2 = temp;
    return lastElement;

};

/**
 * @return {number}
 */
MyStack.prototype.top = function() {
    let n = this.q1.length;
    // same as pop just instead of removing the last element add that to q2 as well
    for(let i=0;i<n-1;i++){
        let firstElement = this.q1.shift();
        this.q2.push(firstElement);
    }
    let lastElement = this.q1.shift();
    this.q2.push(lastElement);
    let temp = this.q1;
    this.q1 = this.q2;
    this.q2 = temp;

    return lastElement;
};

/**
 * @return {boolean}
 */
MyStack.prototype.empty = function() {
    let n = this.q1.length;
    if(n > 0) return false;
    return true;
};

/** 
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */