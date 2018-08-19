package insertSort;

/**
 * User:  Chunguang Li
 * Date:  2018/8/19
 * Email: licgbeyond@foxmail.com
 */

/**
 * 插入排序：平均时间复杂度O(n^2)，但是在接近有序的数组（1. 数组元素取值范围虽然很大，但是基本有序；2. 数组大，但是取值范围很小，同样接近有序）排序时，时间复杂度为O(n)，效率极快。
 */
public class InsertSort {

    public static void sort(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        for (int i = 1; i < arr.length ; i++) {
            // 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入，前面的序列已经是有序的
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
    }

    public static void sort2(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        for (int i = 1; i < arr.length ; i++) {
            int t = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (t < arr[j - 1])
                    arr[j] = arr[j - 1];
                else
                    break;
            }
            arr[j] = t;
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
