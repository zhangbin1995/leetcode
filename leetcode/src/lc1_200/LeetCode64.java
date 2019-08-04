package lc1_200;

/**
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class LeetCode64 {

    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(arr));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1 ; i < m ; i ++){
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        for (int i = 1 ; i < n ; i ++){
            res[0][i] = res[0][i-1] + grid[0][i];
        }
        for (int i = 1 ; i < m ; i ++) {
            for (int j = 1 ; j < n ; j ++) {
                if (res[i-1][j] < res[i][j-1]) {
                    res[i][j] = res[i-1][j] + grid[i][j];
                } else {
                    res[i][j] = res[i][j-1] + grid[i][j];
                }
            }
        }
        return res[m-1][n-1];
    }
}
