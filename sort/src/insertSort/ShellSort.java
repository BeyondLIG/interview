package insertSort;

/**
 * User:  Chunguang Li
 * Date:  2018/8/19
 * Email: licgbeyond@foxmail.com
 */

/**
 * 希尔排序：插入排序的改进版，插入排序在基本有序的情况下，排序效率极快，所以先将数组分为几段接近有序的子序列，再进行排序。
 */
public class ShellSort {
    public static void sort(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        int n = arr.length;
        // 计算 increment sequence
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1){
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                int t = arr[i];
                int j = i;
                for (; j >= h  ; j -= h) {
                        if (t < arr[j - h])
                            arr[j] = arr[j - h];
                        else
                            break;
                }
                arr[j] = t;
            }
            h /= 3;
        }
    }


    public static void main(String[] args) {
        int arr[] = {10,9,8,7,6,5,4,3,2,1};
        sort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }
}
