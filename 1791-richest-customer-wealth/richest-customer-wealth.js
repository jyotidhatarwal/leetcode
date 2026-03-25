/**
 * @param {number[][]} accounts
 * @return {number}
 */
var maximumWealth = function(accounts) {
    let maximum = 0;
    let m = accounts.length;
    let n = accounts[0].length;
    for(let i=0;i<m;i++){
        let sum = 0;
        for(let j=0;j<n;j++){
            sum += accounts[i][j];
        }
        maximum = Math.max(sum,maximum);
    }
    return maximum;
};