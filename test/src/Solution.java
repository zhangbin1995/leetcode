import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length <= 0 || pairs[0].length <= 0) {
            return 0;
        }
        if (pairs.length == 1) {
            return 1;
        }
//        Arrays.sort(pairs, (a,b) -> (a[0] - b[0]));
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        for (int i = 1 ; i < pairs.length ; i ++) {
            int temp = 1;
            for (int j = 0 ; j < i ;j ++) {
                if (pairs[i][0] > pairs[j][1]) {
                    temp = Math.max(temp, dp[j] + 1);
                }
            }
            dp[i] = temp;
        }
        int res = 0;
        for (int i = 0 ; i < dp.length ; i ++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}