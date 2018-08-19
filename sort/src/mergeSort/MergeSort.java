package mergeSort;

/**
 * User:  Chunguang Li
 * Date:  2018/8/19
 * Email: licgbeyond@foxmail.com
 */

import java.util.Arrays;

/**
 * 归并排序：分而治之，平均时间复杂度O(nlogn),将数组分为越来越小的数组，再合并排序数组，需要额外的空间开销。
 */
public class MergeSort {
    public static void sort(int[] arr, int l, int r){
        if (l >= r)
            return;

        // step1：排序
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // step2：合并
        if (arr[mid] > arr[mid+1])
            merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid){
                arr[k] = aux[j-l];
                j++;
            }else if (j > r){
                arr[k] = aux[i-l];
                i++;
            }else if (aux[i-l] < aux[j-l]){
                arr[k] = aux[i-l];
                l++;
            }else {
                arr[k] = aux[j-l];
                j++;
            }
        }
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
