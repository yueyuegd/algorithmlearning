package net.zhangyue.algorithmlearning.leetcode;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        //'z':122 - 'A':65
        int[] counts = new int[58];
        for (char c : s.toCharArray()) {
            counts[c - 'A'] += 1;
        }
        int result = 0;
        for (int count : counts) {
            //偶数个
            if (count % 2 == 0) {
                result = result + count;
            } else {
                //奇数个的话，拿出偶数个，再减去一个
                result = result + (--count);
            }
        }
        //有奇数的话随便取一个放在回文中间所以需要加一
        return result < s.toCharArray().length ? result + 1 : result;
    }

    public static void main(String[] args) {
       /*String s = "abccccdd";
       System.out.println(longestPalindrome(s));*/
       String s = "ccc";
       System.out.println(longestPalindrome(s));
    }
}
