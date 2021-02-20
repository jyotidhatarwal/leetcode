class Solution {
public int romanToInt(String s) {
HashMap<Character,Integer> map = new HashMap<>();
map.put('I',1);
map.put('V',5);
map.put('X',10);
map.put('L',50);
map.put('C',100);
map.put('D',500);
map.put('M',1000);
char wordA[] = s.toCharArray();
int n = wordA.length,val=0;
for(int i=0;i<n;i++){
if(i<n-1 &&map.get(wordA[i+1])>map.get(wordA[i])){
val+=map.get(wordA[i+1]) - map.get(wordA[i]);
i++;
continue;
}
val+=map.get(wordA[i]);
}
return val;
}
}
