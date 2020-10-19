package net.zhangyue.algorithmlearning.leetcode;

import java.util.Arrays;

/**
 * 合并排序的数组：
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 *
 *
 */
public class Merge {

    public static void merge(int[] A, int m, int[] B, int n) {
        for (int i = m; i < m + n; i++) {
            A[i] = B[i - m];
        }
        //冒泡排序
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] B = new int[]{2,5,6};
        int n = 3;
        merge(A, m, B, n);
        A = new int[]{2,0};
        m = 1;
        B = new int[]{1};
        n = 1;
        merge(A, m, B, n);
    }
}
