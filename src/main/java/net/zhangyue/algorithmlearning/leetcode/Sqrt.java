package net.zhangyue.algorithmlearning.leetcode;

/**
 * 求平方根：
 * 写一个函数，求平方根，函数参数为目标数字和精度，
 * 测试案例 fn(4.1,0.001) fn(501.1,0.001) fn(0.045,0.001)
 */
public class Sqrt {

    public double fn(double n, double e) {
        //String d = String.valueOf(e);
        //int length = d.length() - 2;
        double low = 0;
        double high = n;
        double mid = low + (high - low)/2;
        while (high - low > e) {
            //float mid = Float.parseFloat(String.format("%." + length + "f", (low + high)/2));
            if (mid * mid < n) {
                low = mid;
            } else if (mid * mid > n) {
                high = mid;
            } else {
                return mid;
            }
            mid = low + (high - low)/2;
        }
        return mid;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.fn(4.1,0.001));
        System.out.println(sqrt.fn(501.1,0.001));
        System.out.println(sqrt.fn(0.045,0.001));

    }

}
