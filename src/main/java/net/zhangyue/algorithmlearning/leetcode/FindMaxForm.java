package net.zhangyue.algorithmlearning.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 *
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 *
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。
 * 每个 0 和 1 至多被使用一次。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出: 4
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * 示例 2:
 *
 * 输入: strs = ["10", "0", "1"], m = 1, n = 1
 * 输出: 2
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 *
 *
 */
public class FindMaxForm {

    public static int findMaxForm(String[] strs, int m, int n) {
        char[] originStr = new char[m + n];
        for (int i = 0; i < m; i++) {
            originStr[i] = '0';
        }
        for (int i = m; i < m + n; i++) {
            originStr[i] = '1';
        }
        int count = 0;

        for (String str : strs) {
            char[] in = str.toCharArray();
            int cmpCount = 0;
            Map<Integer, Character> refreshIndex = new HashMap<>();
            for (int i = 0; i < in.length; i++) {
                for (int j = 0; j < m + n; j++) {
                    if (in[i] == originStr[j]) {
                        cmpCount++;
                        refreshIndex.put(j, originStr[j]);
                        originStr[j] = '2';
                        break;
                    }
                }
            }
            if (cmpCount == in.length) {
                count++;
            } else {
                for (Map.Entry<Integer, Character> entry : refreshIndex.entrySet()) {
                    int index = entry.getKey();
                    char value = entry.getValue();
                    originStr[index] = value;
                }
            }
        }
        return count;
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--) {
                for (int ones = n; ones >= count[1]; ones--) {
                    dp[zeroes][ones] = Math.max
                            (1 + dp[zeroes - count[0]][ones - count[1]],
                                    dp[zeroes][ones]);
                }
            }

        }
        return dp[m][n];
    }
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }

    public static void main(String[] args) {
        FindMaxForm findMaxForm = new FindMaxForm();
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(strs, m, n));
        System.out.println(findMaxForm.findMaxForm2(strs, m, n));
        strs = new String[]{"10", "0", "1"};
        m = 1;
        n = 1;
        System.out.println(findMaxForm(strs, m, n));
        System.out.println(findMaxForm.findMaxForm2(strs, m, n));
    }
}
