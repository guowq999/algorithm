package class02;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Code02_MergeSort {
    public static void main(String[] args) {
        int[] arr = {9,3,8,6,1,4,7,8,5};
        process(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void process(int[] arr, int left, int  right) {
        if (right <= left) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right-left+1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left+i] = help[i];
        }
    }
}
