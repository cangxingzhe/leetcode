package leetcode.search;

public class $547_2 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{1,0,0,1},
                new int[]{0,1,1,0},
                new int[]{0,1,1,1},
                new int[]{1,0,1,1},
        };
        System.out.println(new $547_2().findCircleNum(grid));
    }

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int[] visited = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if(visited[i] == 0) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, int[] visited) {
        visited[i] = 1;
        for (int j = 0; j < isConnected.length; j++) {
            if(visited[j] == 0 && isConnected[i][j] == 1) {
                dfs(isConnected, j, visited);
            }
        }
    }


}
