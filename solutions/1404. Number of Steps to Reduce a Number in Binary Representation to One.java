class Solution {
    public int numSteps(String s) {
      
        // First, let's calculate the number of trailing zeros
        // We start at the end and decrement the counter until we reach '1'
        int i = s.length() - 1;
        while (s.charAt(i) == '0') {
            i--;
        }
        
        if (i == 0) { // The number of form '1000...0'
            return s.length() - 1; // Number of rule 1 steps to remove all zeros
        }
        
        // Number of trailing zeros is the difference between starting and current positions
        int trailingZeros = s.length() - 1 - i;
        
        // Now let's count the number of ones
        // We continue from the current position, since we've skipped only zeros
        int ones = 0;
        while (i >= 0) {
            ones += s.charAt(i) - '0'; // The same as: if (s.charAt(i) == '1') ones++;
            i--;
        }
        
        // Now, let's calculate the total number of steps
        // Total number of binary digits is s.length()
        // Number of zeros is s.length() - ones
        // Number of rule 1 steps: s.length()
        // Number of rule 2 steps (1 + non-trailing zeros):
        //     1 + zeros - trailingZeros, or 1 + s.length() - ones - trailingZeros
        // Rule 1 steps + rule 2 steps: 1 + 2 * s.length() - ones - trailingZeros
        return 1 + 2 * s.length() - ones - trailingZeros;
    }
}
