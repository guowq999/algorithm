package class01;

import common.ArraysUtil;

import java.util.Arrays;

/**
 * 有序列表，相当值的最左位置
 *
 * 1 2 2 2 3 3 3 3 4 4  5  6  7
 *
 * 1 2 3 4 5 6 7 8 9 10 11 12 13
 *
 */
public class Code05_BSNearLeft {

    // 在arr中，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0;
        int right = arr.length - 1;
        int index = -1; // 记录最左的对号

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= value) {
                right = mid - 1;
                index = mid;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,2,2,3,3,3,3,4,4,5,6,7};
//        System.out.println(nearestIndex(arr, 3));

        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != nearestIndex(arr, value)) {
                ArraysUtil.printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(nearestIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    // for test
    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
