class Solution {
    List<Set<Integer>> tree;
    int[] res, count;
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<>(); // a list of N HashSets
        res = new int[N]; 
        count = new int[N]; 
        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<Integer>());
        } 
        for (int[] edge: edges) { 
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        } 
        postDFS(0, -1); // O(N) time, O(h) space
        preDFS(0, -1);
        return res;
    }
    
    private void postDFS(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i != pre) { // only care about i's children
                postDFS(i, root);
                count[root] += count[i]; // nodes in subtree root
                res[root] += res[i] + count[i]; // sum distance at root
            }
        }
        count[root]++; // the root node itself 
    }
    
    private void preDFS(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i != pre) {
                res[i] = res[root] - count[i] + count.length - count[i];
                preDFS(i, root);
            }
        }
    }    
}
