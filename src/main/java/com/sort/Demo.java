package com.sort;

import java.util.Arrays;
import java.util.Random;

public class Demo {
    int a = 10;

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        //int[] arr = {55,98,5,45,67,46};
        QuickSort.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));



    }
}
