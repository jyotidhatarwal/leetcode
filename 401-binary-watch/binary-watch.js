/**
 * @param {number} turnedOn
 * @return {string[]}
 */
var readBinaryWatch = function(turnedOn) {
    const result = [];

    for (let hour = 0; hour < 12; hour++) {
        for (let minute = 0; minute < 60; minute++) {
            const bits = countBits(hour) + countBits(minute);
            
            if (bits === turnedOn) {
                result.push(
                    hour + ":" + minute.toString().padStart(2, "0")
                );
            }
        }
    }

    return result;
};

function countBits(num) {
    let count = 0;
    while (num > 0) {
        count += num & 1;
        num >>= 1;
    }
    return count;
}