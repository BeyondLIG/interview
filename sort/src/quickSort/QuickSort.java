package quickSort;

/**
 * User:  Chunguang Li
 * Date:  2018/8/19
 * Email: licgbeyond@foxmail.com
 */

/**
 * 快速排序：平均时间复杂度O(nlogn),分而治之，将数组分为小于n和大于n的两部分，再递归对两部分排序。
 */
public class QuickSort {
    public static void sort(int[] arr, int l, int r){
        if (l >= r)
            return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int index = (int) (Math.random() * (r - l) + l);
        swap(arr, l, index);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < arr[l]){
                swap(arr, j+1, i);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        int arr[] = {10,9,8,7,6,5,4,3,2,1};
        sort(arr, 0, 9);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }
}
