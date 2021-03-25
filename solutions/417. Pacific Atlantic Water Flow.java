        for (int i = 0; i < numCols; i++) {
            pacificQueue.offer(new int[]{0, i});
            atlanticQueue.offer(new int[]{numRows - 1, i});
        }
        
        // Perform a BFS for each ocean to find all cells accessible by each ocean
        boolean[][] pacificReachable = bfs(pacificQueue);
        boolean[][] atlanticReachable = bfs(atlanticQueue);
        
        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }
    
    private boolean[][] bfs(Queue<int[]> queue) {
        boolean[][] reachable = new boolean[numRows][numCols];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            // This cell is reachable, so mark it
            reachable[cell[0]][cell[1]] = true;
            for (int[] dir : DIRECTIONS) { // Check all 4 directions
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                // Check if new cell is within bounds
                if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                    continue;
                }
                // Check that the new cell hasn't already been visited
                if (reachable[newRow][newCol]) {
                    continue;
                }
                // Check that the new cell has a higher or equal height,
                // So that water can flow from the new cell to the old cell
                if (landHeights[newRow][newCol] < landHeights[cell[0]][cell[1]]) {
                    continue;
                }
                // If we've gotten this far, that means the new cell is reachable
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return reachable;
    }
}
