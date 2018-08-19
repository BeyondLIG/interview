package selectionSort;

/**
 * User:  Chunguang Li
 * Date:  2018/8/19
 * Email: licgbeyond@foxmail.com
 */


/**
 * 选择排序：时间复杂度为O(n^2)，效率低，速度慢
 */
public class SelectionSort {
    public static void sort(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        for (int i = 0; i < arr.length; i++ ){         // 外层循环次数
            // 1. 每次遍历找出最小元素的下标
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){  // 内层交换元素
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }
            // 2. 将最小元素移到数组位置i
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int minIndex){
        if (i != minIndex){
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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
