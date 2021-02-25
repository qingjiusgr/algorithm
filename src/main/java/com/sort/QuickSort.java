package com.sort;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 快排
     *
     * @param arr   源数组
     * @param left  左侧下标
     * @param right 右侧下标(不能是数组长度)
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right)
            return;

        // 左右索引
        int l = left;
        int r = right;
        // 基准数
        int standard = arr[left];
        int temp = 0;

        // 循环
        while (l < r) {
            // 1、先从右往左找，找一个比基准数小的
            // 2、再从左往右找，找一个比基准数大的
            while (r > l && arr[r] >= standard)
                r--;
            while (l < r && arr[l] <= standard)
                l++;
            //数值交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        // 如果跳出循环，左右两个指针相遇，将相遇位置和基准数交换
        arr[left] = arr[l];
        arr[l] = standard;

        // 这时候，基准数左边的都不比基准数大，右边的不比基准数小
        quickSort(arr, left, l-1);
        quickSort(arr, r+1, right);
    }


}
