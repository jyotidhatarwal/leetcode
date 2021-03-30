            int lo=0, hi=ans;
            
            while(lo<hi){
                int mid=(lo + hi)/2;
                if(minele[mid]<val){
                    lo=mid+1;
                }else{
                    hi=mid;
                }
            }
            minele[lo]=val;
            
            if(lo==ans){
                ans++;
            }
        }
        return ans;
    }
    
    public static class Pair implements Comparable<Pair>{
        int w;
        int h;
        
        Pair(int w,int h){
            this.w=w;
            this.h=h;
        }
        
        @Override
        public int compareTo(Pair other){
            if(this.w==other.w) return other.h -this.h;
            return this.w-other.w;
        }
    }
}
