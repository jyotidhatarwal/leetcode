class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> letters = new HashMap<>();
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), result, letters);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path,
                           List<String> result, Map<Character, String> letters) {
        
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String choices = letters.get(digits.charAt(index));
        
        for (int i = 0; i < choices.length(); i++) {
            path.append(choices.charAt(i));
            backtrack(digits, index + 1, path, result, letters);
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }
}