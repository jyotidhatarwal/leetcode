/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
var hasAllCodes = function(s, k) {
     const needed = 1 << k;  // 2^k

    if (s.length - k + 1 < needed) {
        return false;
    }

    const seen = new Set();

    for (let i = 0; i <= s.length - k; i++) {
        seen.add(s.substring(i, i + k));
        if (seen.size === needed) {
            return true;
        }
    }

    return false;
};