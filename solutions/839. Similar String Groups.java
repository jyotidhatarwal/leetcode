class Solution {
    int[] parent;
    private int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
         parent[x] = temp;
        return temp;
    }
    private boolean isSimilar(String s1,String s2){
        int count =0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i) && ++count > 2 ) return false;
        }
        return true;
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        
        parent = new int[n];
        // initialyy everyone is parent of itself
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int count =n;
        for(int i=0;i<n;i++){
            int p1 = find(i);
            for(int j= i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j])){
                    int p2 = find(j);
                    if(p1 != p2){
                        parent[p2] = p1;
                        count--;
                }
            }
        }
        }
        return count;
    }
}
