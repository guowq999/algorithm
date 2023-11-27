package class02;

/**
 * 小和问题
 */
public class Code03_SmallSum {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        int smallSum = process(arr, 0, arr.length - 1);
        System.out.println(smallSum);
    }

    public static int process(int[] arr, int left, int right) {
        if (right <= left) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);

        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? (right-p2+1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
//            比较的时候才加和
//            res += (right-p2+1)*arr[p1];
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

        return res;
    }
}
