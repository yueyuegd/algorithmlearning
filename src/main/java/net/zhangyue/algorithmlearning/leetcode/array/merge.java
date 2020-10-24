package net.zhangyue.algorithmlearning.leetcode.array;

import java.util.Arrays;

/**
 * 88.合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例：
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出：[1,2,2,3,5,6]
 * 提示：
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 *
 * 使用双指针方法：
 * 先复制一份nums1,称为nums1_copy,使用原本的nums1作为最后结果数组，
 * p1指向nums1_copy数组开头，p2指向nums2开头，比较大小，较小的那个值放入nums1数组中，
 * 如果是nums1_copy中值较小则移动该数组的指针，如果是nums2中值较小移动该数组的指针，
 * 最后还要判断哪个数组还没有结束，没有结束的表示比当前nums1中的值都要大，则直接全部复制到nums1数组的后面
 */
public class merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        for (int i = 0; i < m; i++){
            nums1_copy[i] = nums1[i];
        }
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            if (nums1_copy[p1] < nums2[p2]) {
                nums1[p++] = nums1_copy[p1];
                p1++;
            } else {
                nums1[p++] = nums2[p2];
                p2++;
            }
        }
        if (p1 < m) {
            for (int i = p; i < m + n; i++) {
                nums1[i] = nums1_copy[p1];
                p1++;
            }
        }
        if (p2 < n) {
            for (int i = p; i < m + n; i++) {
                nums1[i] = nums2[p2];
                p2++;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }
}
