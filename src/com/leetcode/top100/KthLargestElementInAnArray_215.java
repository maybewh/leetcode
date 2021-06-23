package com.leetcode.top100;

/**
 * 求TopK的问题，堆排序的时间
 */
public class KthLargestElementInAnArray_215 {

    public static void main(String[] args) {
        KthLargestElementInAnArray_215 element = new KthLargestElementInAnArray_215();
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(element.findKthLargest(arr, k));
    }

    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;

        buildMaxHeap(nums, len);
        int result = nums[k];
        for (int i = len - 1; i >= len - k ; i--) {
            result = nums[0];
            swap(nums, 0, i);
            buildMaxHeap(nums, i);
        }
        return result;
    }

    public void buildMaxHeap(int[] arr, int len) {
        // 从len/2开始，也就是从叶子节点开始，由底向上
        int mid = len / 2;
        for (int i = mid; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    public void heapify(int[] arr, int i, int len) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest, len);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
