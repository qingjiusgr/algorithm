package com.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    /**
     * 归并排序
     *
     * @param array 源数组
     * @return 排序后的数组
     */
    public static int[] mergeSort(int[] array) {
        // 如果数组只有一个元素，没必要排序，直接返回
        if (array.length < 2)
            return array;
        // 将数组对半砍，分为左右两个数组
        int cut = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, cut);
        int[] right = Arrays.copyOfRange(array, cut, array.length);

        // 1、先递归调用当前方法拆分当前数组，拆到数组内只剩一个元素为止
        // 2、数组拆完后，调用排序方法
        return mergeASC(mergeSort(left), mergeSort(right));
    }


    /**
     * 归并排序子模块：排序
     *
     * @param left  左数组
     * @param right 右数组
     * @return
     */
    public static int[] mergeASC(int[] left, int[] right) {
        // 创建一个数组存储排序后的数组，插入法
        int[] result = new int[left.length + right.length];

        // 利用循环逐个向 result 中插入数据
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                // left 数组遍历完了，直接插入 right 数组的值
                result[index] = right[j++];
            } else if (j >= right.length) {
                // right 数组遍历完了，直接插入 left 数组的值
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                // 两个数组都没有遍历完，判断当前两个数组的值大小，将值保存到 result 中
                result[index] = right[j++];
            } else {
                // 两个数组都没有遍历完，判断当前两个数组的值大小，将值保存到 result 中
                result[index] = left[i++];
            }
        }
        return result;
    }

}
