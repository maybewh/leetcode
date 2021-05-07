package com.leetcode.top100;

public class JumpGame_55 {

    public boolean canJump(int[] nums) {

        if(nums == null || nums.length == 0){
            return true;
        }

        int max = 0;
        // 思路：计算当前位置之前（含当前位置）能到后面的最大距离
        for (int i = 0; i < nums.length; i++) {
            if (i > max) { //说明前面能达到的最大位置并不能到达该处，也就无法跳跃到最后一个位置
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        JumpGame_55 jumpGame_55 = new JumpGame_55();
        int[] nums = {2,3,1,1,4};
        boolean result = jumpGame_55.canJump(nums);
        System.out.println(result);
    }
}
