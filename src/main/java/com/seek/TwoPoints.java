package com.seek;

import java.util.ArrayList;

/**
 * 二分查找
 */
public class TwoPoints {

    /**
     * 二分查找：递归实现
     *
     * @param arr   源数组
     * @param value 要查找的值
     * @param left  左侧索引
     * @param right 右侧索引
     * @return
     */
    public static int getIndex(int[] arr, int value, int left, int right) {
        // 没找到，返回 -1
        if (left > right)
            return -1;

        // 中间数
        int middle = (left + right) / 2;
        if (value < arr[middle])
            return getIndex(arr, value, left, middle - 1);
        else if (value > arr[middle])
            return getIndex(arr, value, middle + 1, right);

        return middle;
    }

    /**
     * 二分查找，循环实现
     *
     * @param arr   源数组
     * @param value 需要查找的下标
     * @return
     */
    public static int getIndex2(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        for (; ; ) {
            if (left > right)
                return -1;

            int middle = (left + right) / 2;
            if (value < arr[middle])
                right = middle - 1;
            else if (value > arr[middle])
                left = middle + 1;
            else if (value == arr[middle])
                return middle;
        }
    }

    /**
     * 二分查找：返回的是数组的下标
     *
     * @param arr    源数组
     * @param finVal 需要查找的值
     * @return
     */
    public static ArrayList<Integer> getArrIndex(int[] arr, int finVal) {
        if (arr.length < 1 || arr == null)
            return null;

        // resArr 存放结果
        ArrayList list = new ArrayList();
        int resIndex = 0;

        int result = getIndex2(arr, finVal);
        list.add(result);

        int temp = result;
        while (temp > 0 && arr[--temp] == finVal)
            list.add(temp);

        temp = result;
        while (temp < arr.length - 1 && arr[++temp] == finVal)
            list.add(temp);

        return list;
    }

}
