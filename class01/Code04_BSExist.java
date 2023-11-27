package class01;

import java.util.Arrays;

/**
 * 用二分法搜索一个数是否存在
 */
public class Code04_BSExist {
    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) return false;

        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] < num) {
                left = mid + 1;
            }
            if (arr[mid] > num) {
                right = mid - 1;
            }
            if (arr[mid] == num) {
                return true;
            }
        }
        return arr[left] == num;
    }

    public static void main(String[] args) {
//        int[] arr = {1,3,4,5,6,7,12,43,54};
//        System.out.println(exist(arr, 6));

        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    // for test
    public static boolean test(int[] sortedArr, int num) {
        for(int cur : sortedArr) {
            if(cur == num) {
                return true;
            }
        }
        return false;
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
