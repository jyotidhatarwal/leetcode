class Solution {
    static HashSet<Character> VOWELS = new HashSet<>(List.of('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'));
    
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        
        //count vowels first, and second half
        return countVowels(s, 0, (n / 2) - 1) == countVowels(s, (n / 2), n - 1);
    }
    
    private int countVowels(String s, int start, int end){
        int count = 0;
        for(int i = start; i <= end; i++){
            count += VOWELS.contains(s.charAt(i)) ? 1 : 0;
        }
        
        return count;
    }
}
