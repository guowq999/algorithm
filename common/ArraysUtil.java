package common;


import java.util.Arrays;

/**
 * 数组相关的工具类
 */
public class ArraysUtil {
    /**
     * 交换数组两个位置的元素 【从0开始】
     * 【 i 和 j是一个位置的话，会出错】
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 复制一个数组生成一个新数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 随机生成一个数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() [0,1)
        // Math.random * N [0,N)
        // (int)(Math.random() * N) [0, N-1]
        int[] arr = new int[(int) ((maxSize +1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-?, +?]
            arr[i] = (int) ((maxValue +1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 判断两个数组是否相同
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        swap(arr, 3, 5);
        System.out.printf(Arrays.toString(arr));
    }
}
