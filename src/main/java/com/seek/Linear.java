package com.seek;

/**
 * 顺序查找，也叫线性查找
 */
public class Linear {

    /**
     * 线性查找
     * @param arr 源表
     * @param value 需要查找的值
     * @return 找到返回下标，否则返回 -1
     */
    public static int getIndex(int[] arr, int value){
        for (int i = 0 ; i < arr.length; i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

}
