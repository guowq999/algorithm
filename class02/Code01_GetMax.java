package class02;

/**
 * 用递归方法求一个数组的最大值
 */
public class Code01_GetMax {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int max = getMax(arr, 0, arr.length - 1);
        System.out.println(max);
    }

    public static int getMax(int[] arr, int left, int right) {
        // 退出条件 arr[left,right]数组上只有一个数了，直接返回，base case
        if (left == right) {
            return arr[left];
        }
        // 求中间值
        int mid = left + ((right - left) >> 1);
        int maxLeft = getMax(arr, left, mid);
        int maxRight = getMax(arr, mid+1, right);
        return Math.max(maxLeft, maxRight);
    }
}
