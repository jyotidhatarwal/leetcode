/**
 * @param {string} s
 * @return {string}
 */
var makeLargestSpecial = function(s) {
    let parts = [];
    let balance = 0;
    let last = 0;

    for (let i = 0; i < s.length; i++) {
        // Increase for '1', decrease for '0'
        balance += s[i] === '1' ? 1 : -1;

        // When balance is zero, we found a top-level special substring 
        if (balance === 0) {
            // We take the inner part, recursively fix it,
            // then wrap it again with '1' and '0'.
            let inner = s.slice(last + 1, i);
            parts.push("1" + makeLargestSpecial(inner) + "0");
            last = i + 1;
        }
    }

    // Sort in descending lexicographical order
    parts.sort((a, b) => (b > a ? 1 : -1));

    // Join and return
    return parts.join("");
};