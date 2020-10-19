package net.zhangyue.algorithmlearning.leetcode;

/**
 * 正则表达式匹配：
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 *示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 *
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {

            if (p.charAt(0) == '*') {
                dp[0][1] = false;
                continue;
            }

            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int si = 1; si <= m; si++) {
            for (int pi = 1; pi <= n; pi++) {
                if (p.charAt(pi - 1) == s.charAt(si - 1) || p.charAt(pi - 1) == '.') {
                    dp[si][pi] = dp[si - 1][pi - 1];
                }

                else if (p.charAt(0) == '*') {
                    continue;
                }

                else if (p.charAt(pi - 1) == '*') {
                    if (p.charAt(pi - 2) == s.charAt(si - 1) || p.charAt(pi - 2) == '.') {
                        dp[si][pi] = dp[si][pi - 2] || dp[si - 1][pi];
                    } else {
                        dp[si][pi] = dp[si][pi - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        String s = "aa";
        String p = "a";
        System.out.println(isMatch.isMatch(s, p));
        s = "aa";
        p = "a*";
        System.out.println(isMatch.isMatch(s, p));
        s = "ab";
        p = ".*";
        System.out.println(isMatch.isMatch(s, p));
        s = "aab";
        p = "c*a*b";
        System.out.println(isMatch.isMatch(s, p));
        s = "mississippi";
        p = "mis*is*p*.";
        System.out.println(isMatch.isMatch(s, p));
    }


}
