package class01;

import common.ArraysUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Code02_BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    ArraysUtil.swap(arr, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {6,2,3,1,5,4};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArraysUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ArraysUtil.copyArray(arr1);
            bubbleSort(arr1);
            Arrays.sort(arr2);
            if (!ArraysUtil.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
