package lc1_200;

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * @author binzhang
 * @date 2019-08-11
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m  == 1 || n == 1) {
            return 1;
        }
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 1 ; i < m ; i ++) {
            res[i][0] = 1;
        }
        for (int i = 1 ; i < n ; i ++) {
            res[0][i] = 1;
        }
        for (int i = 1 ; i < m ; i ++) {
            for (int j = 1 ; j < n ; j ++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }
}
