package com.seek;

public class Test {
    // 主函数
    public static void main(String[] args) {
        int[] arr = {0,11,34,56,56,88,88,99,100,100};
        //System.out.println(TwoPoints.getArrIndex(arr, 56).toString());
        int result = Difference.getIndex(arr,11);
        System.out.println(result);
    }
}
