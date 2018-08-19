package bubbleSort;

/**
 * User:  Chunguang Li
 * Date:  2018/8/19
 * Email: licgbeyond@foxmail.com
 */

/**
 * 冒泡排序：每次找出最大的元素放在数组后面
 */
public class BubbleSort {
    public static void sort(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        for (int i = 0; i < arr.length - 1; i++) {        // 外层循环次数
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {  // 内层交换元素
                // 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }

            if (flag)
                break;
        }
    }

    private static void swap(int[] arr, int i, int j) {
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
