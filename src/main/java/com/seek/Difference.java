package com.seek;

/**
 * 差值查找
 */
public class Difference {

    /**
     * 二分查找
     *
     * @param arr 源数组
     * @param key 需要查找的值
     * @return 找到返回下标，否则返回 -1
     */
    public static int getIndex(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int mind;
        for (; ; ) {
            // 如果数组不正常或者，需要查找的数比数组内最大的大，或者比最小的小，就没有比较的必要了
            if (left > right || key < arr[left] || key > arr[right]) {
                return -1;
            }

            // 差值查找公式
            mind = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);

            // 如果需要查找的数比 arr[mind] 小，缩小右边范围，如果大就缩小左边范围，如果相等就返回。
            if (key < arr[mind]){
                right = mind - 1;
            }
            else if (key > arr[mind]){
                left = mind + 1;
            }
            else {
                return mind;
            }

        }
    }
}
