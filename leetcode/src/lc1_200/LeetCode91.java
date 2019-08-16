package lc1_200;

/**
 * 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * @author binzhang
 * @date 2019-08-16
 */
public class LeetCode91 {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.equals("0") || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {
            if (s.charAt(1) == '0') {
                if (s.charAt(0) > '2') {
                    return 0;
                }
                return 1;
            }
            else if (s.charAt(0) == '1') {
                return 2;
            } else if (s.charAt(0) == '2' && s.charAt(1) <= '6') {
                return 2;
            } else {
                return 1;
            }
        }
        for (int i = 1 ; i <= 2 ; i ++) {
            dp[1] = 1;
            if (s.charAt(1) == '0') {
                if (s.charAt(0) > '2') {
                    dp[2] = 0;
                } else {
                    dp[2] = 1;
                }
            }else if (s.charAt(0) == '1') {
                dp[2] = 2;
            } else if (s.charAt(0) == '2' && s.charAt(1) <= '6') {
                dp[2] = 2;
            } else {
                dp[2] = 1;
            }
        }
        for (int i = 3 ; i <= s.length() ; i ++) {
            if (s.charAt(i-1) == '0') {
                if (s.charAt(i-2) == '0' || s.charAt(i-2) > '2') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            }
            else if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode91().numDecodings("301"));
    }
}
