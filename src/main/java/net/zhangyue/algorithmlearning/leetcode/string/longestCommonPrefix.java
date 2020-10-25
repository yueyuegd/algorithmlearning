package net.zhangyue.algorithmlearning.leetcode.string;


/**
 * 最长公共前缀:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String one = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String two = strs[i];
            int len = Math.min(one.length(), two.length());
            int count = 0;
            while (count < len && (one.charAt(count) == two.charAt(count))) {
                count++;
            }
            one = one.substring(0, count);
        }
        return one;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
