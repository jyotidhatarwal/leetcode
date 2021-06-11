    public class Pair{
        TreeNode node = null;
        int hl =0;
        Pair(TreeNode node,int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    private void width(TreeNode node,int hl,int[]minMax){
        if(node == null) return;
        minMax[0] = Math.min(minMax[0],hl);
        minMax[1] = Math.max(minMax[1],hl);
        width(node.left,hl-1,minMax);
        width(node.right,hl+1,minMax);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int[]minMax = new int[2];
        width(root,0,minMax);
        int length = minMax[1] - minMax[0] +1;
        for(int i=0;i<length;i++){
            result.add(new ArrayList<>());
        }
        PriorityQueue<Pair> parentQue = new PriorityQueue<>((a,b) ->{
            return a.node.val - b.node.val;
        });
        PriorityQueue<Pair> childQue = new PriorityQueue<>((a,b) -> {
            return a.node.val - b.node.val;
        });
        parentQue.add(new Pair(root,Math.abs(minMax[0])));
        while(parentQue.size() > 0){
            int size = parentQue.size();
​
            while(size-- > 0){
                Pair rem = parentQue.remove();
                TreeNode node = rem.node;
                int hl = rem.hl;
                result.get(hl).add(node.val);
                if(node.left != null){
                    childQue.add(new Pair(node.left,hl-1));
                }
                if(node.right != null){
                    childQue.add(new Pair(node.right,hl+1));
                }
            }
            PriorityQueue<Pair> temp = parentQue;
            parentQue = childQue;
            childQue = temp;
            
        }
        return result;
    }
}
