class Solution {
    public List<Integer> getRow(int rowIndex) {
        //  using nCr and factor i.e nCr*factor = nCr+1
        // nC0 =1
        List<Integer> result = new ArrayList<>();
        int val =1;
        for(int j=0;j<=rowIndex;j++){
            result.add(val);
            long cv=(long)val*(long)(rowIndex-j)/(j+1);
            val = (int)cv;
        }
        return result;
    }
}
