package heapSort;

/**
 * User:  Chunguang Li
 * Date:  2018/8/19
 * Email: licgbeyond@foxmail.com
 */

/**
 * 大根堆排序：动态的优先队列，平均时间复杂度O(nlogn),大根堆维护着数组中最大的元素。对于在1百万个元素中找出前100大小的元素（N中挑M的问题），使用
 * 大根堆是很好的解决方法（1. 不需要一次性读取1百万个元素[内存不够]， 2. 动态排序，大根堆中保存的就是值最大的元素）
 */
public class MaxHeapSort {
    private int[] data;

    private int count;

    public MaxHeapSort(int[] data, int count){
        this.data = data;
        this.count = count;
    }

    // 向堆数组插入一个元素
    public void insert(int item){
        // 添加元素到数组末尾
        data[count + 1] = item;
        // 数组元素+1
        count++;
        // 调用shiftUp方法
        shiftUp(count);
    }

    public int extrace(){
        int t = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);
        return t;
    }

    private  void shiftUp(int k){
        // 和父节点比较
        while (k > 1 && data[k/2] < data[k]){
            swap(data, k, k/2);
            k /= 2;
        }
    }

    private void shiftDown(int k){
        // 和子节点比较
        while ( 2*k <= count){
            int m = 2*k;
            if (m+1 <= count){
                m = data[m+1]>data[m] ? m+1:m;
            }
            if (data[k] < data[m]){
                swap(data, k, m);
            }
            k = m;
        }
    }

    private void swap(int[] data, int i, int j) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String[] args) {
        MaxHeapSort maxHeapSort = new MaxHeapSort(new int[11], 0);
        for (int i = 3; i <= 8; i++) {
            maxHeapSort.insert(i);
        }
        maxHeapSort.insert(20);
        maxHeapSort.insert(16);
        maxHeapSort.insert(1);

        for (int i = 0; i < 9; i++) {
            System.out.print(maxHeapSort.extrace());
            System.out.print(' ');
        }
    }
}
