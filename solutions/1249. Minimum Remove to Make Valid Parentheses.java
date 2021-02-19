class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
        return s;
    }
​
    Stack<Pair<Character,Integer>> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == ')') {
            if (!st.isEmpty() && st.peek().getKey() == '(') {
                st.pop();
            } else {
                st.push(new Pair(c, i));
            }
        } else if (c == '(') {
            st.push(new Pair(c, i));
        }
    }
        
​
    StringBuilder sb = new StringBuilder(s);
    while (!st.isEmpty()) {
        Pair<Character, Integer> pair = st.pop();
        sb.deleteCharAt(pair.getValue());
    }
​
    return sb.toString();
​
    }
}
