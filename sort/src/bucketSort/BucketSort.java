package bucketSort;

/**
 * User:  Chunguang Li
 * Date:  2018/8/19
 * Email: licgbeyond@foxmail.com
 */

/**
 * 桶排序：平均时间复杂度O(n)，但是需要较多的额外空间，对于取值范围较小但是又不适用插入排序的问题可以考虑，为减小空间的使用，可以使用更小的单位存储元素例如以字节为单位。
 */
public class BucketSort {
    public static void sort(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        // arr元组取值范围0-10
        int[] bucket = new int[11];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]] += 1;
        }

        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0){
                while (bucket[i] > 0){
                    bucket[i]--;
                    arr[j++] = i;
                }
            }
        }

//        for (int i = 0; i < bucket.length; i++) {
//            if (bucket[i] != 0){
//                while (bucket[i] > 0){
//                    System.out.print(i);
//                    System.out.print(" ");
//                    bucket[i]--;
//                }
//            }
//        }
    }


    public static void main(String[] args) {
        int arr[] = {9,3,6,10,5,4,3,6,6,0};
        sort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }
}
