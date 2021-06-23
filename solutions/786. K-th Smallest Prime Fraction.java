class Solution {
    class Fraction{
        int x;
        int y;
        
        Fraction(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        int n = arr.length;
        
        PriorityQueue<Fraction> pq = new PriorityQueue<>((a, b) -> {
           return arr[a.x]*arr[b.y] - arr[a.y]*arr[b.x]; 
        });
        
        for(int i = 0; i < n; i++){
            pq.add(new Fraction(i, n - 1));
        }
        
        while(k-- > 1){
            Fraction f = pq.remove();
            if(f.y - 1 >= 0)
                pq.add(new Fraction(f.x, f.y - 1));
        }
        
        
        Fraction f = pq.peek();
        int[] ans = new int[]{arr[f.x], arr[f.y]};
        return ans;
    }
}
