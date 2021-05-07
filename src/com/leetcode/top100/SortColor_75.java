package com.leetcode.top100;

public class SortColor_75 {

    /**
     * 使用双指针，一个指针表示0的位置，另外一个指针表示2的位置。
     * 但是在对2进行交换时，有可能i对应的位置也是2，所以，需要不停的对i进行交换，直到i对应的值不是2。
     * @param nums
     */
    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int zero = 0;
        int two = nums.length - 1;


        for (int i = 0; i < nums.length; i++) {

            // 不停地进行交换，保证two指向的不是2，这样交换后i对应的值才不会为2
            while (nums[i] == 2 && i < two) {
               exchange(nums, two--, i);
            }

            if (nums[i] == 0) {
                exchange(nums, zero++, i);
            }

        }

    }

    public void exchange(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        SortColor_75 sortColor_75 = new SortColor_75();
//        int[] nums = {2,0,2,1,1,0};
//        int[] nums = {2,0,1};
//        int[] nums = {0};
//        int[] nums = {2, 1};
        int[] nums = {2, 0};
        sortColor_75.sortColors(nums);

        for (int i = 0; i < nums.length; i++) {

            System.out.print(nums[i] + " ");

        }
    }

}
