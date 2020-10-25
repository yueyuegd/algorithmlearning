package net.zhangyue.algorithmlearning.leetcode.string;

/**
 * 字符串相加：
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 *
 */
public class addStrings {

    public static String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if (n == 0 && m == 0) {
            return "0";
        }
        int[] array1 = new int[n];
        for (int i = 0 ; i < n; i++) {
            array1[i] = num1.charAt(i) - '0';
        }
        int[] array2 = new int[m];
        for (int i = 0 ; i < m; i++) {
            array2[i] = num2.charAt(i) - '0';
        }
        StringBuffer stringBuffer = new StringBuffer();
        int add = 0;
        int i = n - 1;
        int j = m - 1;
        while (i >= 0 || j >= 0) {
            int one = 0;
            if (i >= 0 && i < n) {
                one = array1[i];
            }
            int two = 0;
            if (j >= 0 && j < m) {
                two = array2[j];
            }
            int result = one + two + add;
            stringBuffer.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        if (add == 1) {
            stringBuffer.append("1");
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        String nums1 = "123";
        String nums2 = "489";
        System.out.println(addStrings(nums1, nums2));
        nums1 = "1";
        nums2 = "9";
        System.out.println(addStrings(nums1, nums2));
    }
}
