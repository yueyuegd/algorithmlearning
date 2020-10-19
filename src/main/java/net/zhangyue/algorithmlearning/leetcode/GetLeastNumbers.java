package net.zhangyue.algorithmlearning.leetcode;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 */
public class GetLeastNumbers {


    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] array = new int[k];
        int count = k;
        //试图使用冒泡排除选出前k个最小的元素
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (count > 0) {
                array[i] = arr[arr.length - i - 1];
                count--;
            } else {
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] arr = {3,2,1};
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
        k = 1;
        arr = new int[]{0,1,2,1};
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }
}
