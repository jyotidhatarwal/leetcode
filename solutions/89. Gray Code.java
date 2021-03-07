class Solution {
    private List<String> calculateGrayCode(int n){
        if(n==0){
            List<String> bres = new ArrayList<>();
            bres.add("0");
            return bres;
        }
        if(n==1){
            List<String> bres = new ArrayList<>();
            bres.add("0");
            bres.add("1");
            return bres;
        }
        List<String> rres = calculateGrayCode(n-1);
        List<String> myres = new ArrayList<>();
        for(int i=0;i<rres.size();i++){
            String rstr = rres.get(i);
            myres.add("0" + rstr);
        }
        for(int i= rres.size()-1;i>=0;i--){
            String rstr = rres.get(i);
            myres.add("1" + rstr);
        }
        return myres;
    }
    
    public List<Integer> grayCode(int n) {
        List<String> StringFormat = calculateGrayCode(n);
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<StringFormat.size();i++){
            String element = StringFormat.get(i);
            result.add(Integer.parseInt(element,2));
        }
        return result;
    }
}
