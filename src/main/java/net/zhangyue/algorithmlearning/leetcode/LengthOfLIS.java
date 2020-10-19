package net.zhangyue.algorithmlearning.leetcode;

/**
 * 最长上升子序列：
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 *
 * 动态规划：
 * 状态：i表示最后一个字符是i的数组
 * dp[i]表示以i作为最后一个数字结尾的数组的最长上升子序列
 * 外层循环以i=0开始，表示以i结尾的数组
 * 内层使用j=0开始循环，在i数组范围内循环，如果nums[i]>nums[j]说明可以作为上升序列
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int[] dp = new int[length];
        //初始化dp数组，假设每个以i结尾的数组以自己作为最大上升子序列
        for (int i = 0; i< length; i++) {
            dp[i] = 1;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //dp[i]:i索引的整数作为自己的最大上升子序列
                    //dp[j] + 1:将自己加入到最大上升子序列中的值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
