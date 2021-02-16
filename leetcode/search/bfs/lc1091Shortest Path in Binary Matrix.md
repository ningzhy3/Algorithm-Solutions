```java

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return -1; // base case
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int pathLength = 0;
        // bfs
        while (!q.isEmpty()) {
            int size = q.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> node = q.poll();
                int x = node.getKey();
                int y = node.getValue();
                if (grid[x][y] == 1) continue;
                if (x == m-1 && y == n-1) return pathLength;
                // 标记访问过的节点
                grid[x][y] = 1; 
                for (int[] dir : direction) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (newX < 0 || newX >= m || newY < 0 || newY >=n) continue;
                    q.offer(new Pair<>(newX, newY));
                }
            }
        }
        return -1;
    }
}