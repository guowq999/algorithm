package class01;

import common.ArraysUtil;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Code03_InsertionSort {
    public static void insertionSort(int[] arr) { // 0 ~ i 做到有序
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >=0 && arr[j] > arr[j+1] ; j--) {
                ArraysUtil.swap(arr, j, j+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
