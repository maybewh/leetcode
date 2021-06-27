package com.leetcode.top100;

public class L_287_FindTheDuplicateNumber {

    /**
     * cnt[i]表示nums数组中小于等于i的个数，重复的值为target。
     * 在[1,target-1]的范围内，cnt[i]<=i;在[target,n]，所有的数都满足cnt[i]>i(因为target重复)。在两个区间内均满足单调性，故可以使用二分查找。
     *
     * 太特么绕了，fuck。我不适合干计算机。。。。
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        int n = nums.length;

        int left = 1, right = n - 1, result = -1;

        while (left <= right) {

            int mid = (left + right) / 2; //中间点
            int cnt = 0; //小于i的个数
            for (int i = 0; i < n; i++) {
                if (nums[i] < mid) { //统计数组中小于中心索引的节点个数，判断target对应在mid的哪部分索引
                    cnt++;
                }
            }

            if (cnt <= mid) {
                left = mid + 1; //说明target在（mid, right)中
            } else {
                right = mid - 1; // 说明target就在（left，mid)中
                result = mid;
            }

        }

        return result;

    }

    /**
     * 以i->nums[i]构建链表，则一定会存在环，因为会有多个i指向target
     */
    public int findDuplicateInCricle(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]]; //走两步，走一步是nums[slow]，所以再走一步是nums[nums[slow]]
        } while (slow != fast); //当slow==fast时，表示快慢指针相遇了

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        } // 相遇后就是target
        return slow;

    }



}
