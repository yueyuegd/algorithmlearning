package net.zhangyue.algorithmlearning.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 分析：
 * 1.字符串只有一个字符的之后，一定是回文
 * 2.字符串包含两个字符的时候，判断这两个字符是否相等，相等的话就是回文
 * 3.字符串包含三个字符的时候，先判断头尾两个字符是否相等，中间无所谓
 * 4.以此类推：定义二维动态数组dp[i][j]，表示以s[i...j]为子串是否是回文：
 * 首先判断首尾的元素，即s[i]和s[j]是否相等，如果不相等一定不是回文
 * 如果相等的话，再判断dp[i+1][j-1]是否是回文
 */
public class LongestPalindrome2 {

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int[] result = new int[2];
        for (int i = length - 1; i >= 0 ; i--) {
            for (int j = i + 1; j < length; j++) {
               if (s.charAt(i) == s.charAt(j)) {
                   if (j - i == 1) {
                       dp[i][j] = true;
                   } else {
                       dp[i][j] = dp[i + 1][j - 1];
                   }
               } else {
                   dp[i][j] = false;
               }
                if(dp[i][j] && result[1] - result[0] <= j - i) {
                    result[0] = i;
                    result[1] = j;
                }
            }

        }
        return s.substring(result[0], result[1] + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        s = "cbbd";
        System.out.println(longestPalindrome(s));
        s = "";
        System.out.println(longestPalindrome(s));
    }
}
