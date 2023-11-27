package class02;

/**
 * 逆序对
 */
public class Code04_ReversePair {
    public static void main(String[] args) {
        int[] arr = {4,5,3,2,0};
        System.out.println(process(arr, 0, arr.length - 1));
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
            res += arr[p1] > arr[p2] ? (mid-p1+1) : 0;
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

        return res;
    }
}
