package net.zhangyue.algorithmlearning.leetcode;

/**
 * 乘积最大子数组：
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 */
public class MaxProduct {

    public static int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] dpMax = new int[length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[length];
        dpMin[0] = nums[0];

        for (int i = 1; i < length; i++) {
            /*if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] * nums[i];
            } else {
                dp[i] = nums[i];
            }*/
            //分情况讨论
            if (nums[i] >= 0 && dpMax[i - 1] > 0) {
                dpMax[i] = dpMax[i - 1] * nums[i];
            } else if (nums[i] >= 0 && dpMax[i - 1] < 0){
                dpMax[i] = nums[i];
            } else if (nums[i] < 0 && dpMin[i - 1] < 0){
                dpMin[i] = dpMin[i - 1] * nums[i];
            } else {
                dpMin[i] = nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < dpMax.length; i++) {
            res = Math.max(res, dpMax[i]);
        }
        for (int i = 0; i < dpMin.length; i++) {
            res = Math.max(res, dpMin[i]);
        }
        return res;
    }


    public static int maxProduct1(int[] nums) {
        //初步分析：1，负负得正 也就是说
        // 如果f(3)=max{f(2),f(2)*v(3)}
        // 如果f(2)是正数  v(3)取值为负数（-1） f(3)=f(2) 关键是v(4)可能是负数（-2）
        // 那么其实f(4)=f(2)*v(2)*v(4)  比之前的正数要大
        // 所以还需要考虑正负数的关系，简单点用一个二维数组 一个存储负数，一个存储正数
        //[2,-5,-2,-4,3]
        //拆解 f(0)=2  f(1)=判断正负 0,-10 f(2)=20,-2 f(3)=8,-80 f(4)=24,-240
        int length = nums.length;
        //存储正数结果级
        int[] arrZheng = new int[length];
        //存储负数结果级
        int[] arrFu = new int[length];
        if(nums.length==0){
            return 0;
        }
        int maxZheng = nums[0];
        int maxFu = nums[0];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                arrZheng[0]=nums[0];
                arrFu[0]=nums[0];
            }else{
                // [2,-5,-2,-4,3]

                if(nums[i]==0){
                    arrZheng[i] = 0;
                    arrFu[i] = 0;
                }
                if(nums[i]<0){
                    arrZheng[i] = Math.max(0,nums[i]*arrFu[i-1]);
                    arrFu[i] = Math.min(nums[i],nums[i]*arrZheng[i-1]);
                }else{
                    arrZheng[i] = Math.max(nums[i],nums[i]*arrZheng[i-1]);
                    arrFu[i] = Math.min(0,nums[i]*arrFu[i-1]);
                }
            }
            maxZheng = Math.max(arrZheng[i],maxZheng);
            maxFu = Math.max(arrFu[i],maxFu);
        }
        // System.out.println("zheng:"+JSON.toJSONString(arrZheng));
        // System.out.println("fu:"+JSON.toJSONString(arrFu));
        return Math.max(maxFu,maxZheng);
    }

    public static void main(String[] args) {
        /*int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
        nums = new int[]{-2,0,-1};
        System.out.println(maxProduct(nums));
        nums = new int[]{-3,-1,-1};
        System.out.println(maxProduct(nums));*/
        /*int[] nums = new int[]{0,2};
        System.out.println(maxProduct(nums));
        nums = new int[]{-2,3,-4};
        System.out.println(maxProduct(nums));*/
        int[] nums = new int[]{0,2};
        System.out.println(maxProduct1(nums));
        nums = new int[]{-2,3,-4};
        System.out.println(maxProduct1(nums));
        nums = new int[]{2,3,-2,4};
        System.out.println(maxProduct1(nums));

    }
}
