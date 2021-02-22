class Solution {
    // Time comlexity - O (n logn) - sorting n words of dictoonary
    //  O ( n x ) - going over the dictionary - x - the length of s
    //  as both n and x may be 1000 at worst, the total worst case time complexity is O (n * n)
​
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            public int compare(String lhs, String rhs) {
                // We will order according the sorting definition - length comes first, then lexicographical order if
                // two strings are of same length.
                if (rhs.length() ==  lhs.length()) {
                     return lhs.compareTo(rhs);
                }
                
                return (rhs.length() - lhs.length()) / Math.abs(rhs.length() - lhs.length());
             }
        });
        
        for (String word: d) {
            // as we sorted the dictionary it is guarenteed that the first matching word answers to the sort condition defined above
            if (isSubs(word, s)) {
                return word;
            }
        }
        
        return "";
                         
    }
    
    private boolean isSubs(String sub, String s) {
        if (sub.length() > s.length()) {
            return false;
        }
        char[] subChars = sub.toCharArray();
        char[] chars = s.toCharArray();
        int subIndex = 0;
        int charIndex = 0;
        while (subIndex < subChars.length && charIndex < chars.length) {
            if (chars[charIndex] == subChars[subIndex]) {
                charIndex++;
                subIndex++;
            } else {
                charIndex++;
            }
        }
        return subIndex == subChars.length;
    }
}
