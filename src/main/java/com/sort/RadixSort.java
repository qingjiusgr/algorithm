package com.sort;


import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    /**
     * 基数排序
     *
     * @param arr 源数组
     * @return 排序后的数组
     */
    public static int[] radixSort(int[] arr) {
        if (arr.length < 2)
            return arr;

        // 新建返回数组
        int[] newArr = Arrays.copyOfRange(arr, 0, arr.length);
        // newArr 下标
        int index = 0;
        // 创建10个桶：每个桶长度为 arr 的 1/8
        int[][] bucket = new int[10][arr.length / 8 + 1];
        // 每个桶里的数值个数
        int[] bucketIndex = new int[10];

        // 获取源数组最大值
        int c = 1;
        int max = newArr[0];
        boolean su = true;

        // do while 保证第一遍 max 获取到值
        do {
            // 遍历新数组，并将数保存到桶中
            for (int i = 0; i < newArr.length; i++) {
                int bucketSerial = newArr[i] / c % 10;
                // bucketSerial：i 属于哪个桶
                // bucketIndex[bucketSerial] 当前对应桶中有多少个数，也就是要保存到对应的桶的位置
                if (bucketIndex[bucketSerial] >= bucket[bucketSerial].length) {
                    // 桶内数据过多，桶太小，对该桶扩容，长度为当前长度的两倍
                    System.out.println("扩容：" + bucketSerial);
                    bucket[bucketSerial] = Arrays.copyOf(bucket[bucketSerial], bucket[bucketSerial].length * 2);
                }
                // 获取源数组最大值，su 用来保证只获取一次
                if (su && max < newArr[i]) {
                    max = newArr[i];
                }
                bucket[bucketSerial][bucketIndex[bucketSerial]++] = newArr[i];
            }
            su = false;

            // 取出桶中数据并保存到新数组中
            index = 0;
            for (int j = 0; j < bucket.length; j++) {
                for (int i = 0; i < bucketIndex[j]; i++) {
                    newArr[index++] = bucket[j][i];
                }
                // 取出对应桶中的数据后，将桶内数值归 0
                bucketIndex[j] = 0;
            }
        } while ((c *= 10) <= max);

        return newArr;
    }
}
