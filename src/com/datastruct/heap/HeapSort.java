package com.datastruct.heap;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

    }

    public int[] sort(int[] sourceArr) {

        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int len = arr.length;
        
        buildMaxHeap(arr, len);

        // 和最后一位交换，逐渐取出最大的元素
        for (int i = len; i >= 0; i--) {
            swap(arr, 0, i);
            buildMaxHeap(arr, --len);
        }

        return arr;
    }

    public void buildMaxHeap(int[] arr, int len) {

        // 从arr.length/2开始，即从下往上进行遍历
        int mid = len / 2;
        for (int i = mid; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * 最大堆调整
     * @param arr
     * @param i
     * @param len
     */
    public void heapify(int[] arr, int i, int len) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[largest] < arr[left]) {
            largest = left; // 减少交换次数
        }

        if (right < len && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) { // 不等，说明调整了顺序，所以换成调整成父节点
            swap(arr, largest, i);
            heapify(arr, largest, len); //继续调整
        }


    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
