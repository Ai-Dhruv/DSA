// 16. 3Sum Closest
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.


import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < n-2 ; i++){
            int left = i+1;
            int right = n-1;

            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];

                if(Math.abs(currentSum - target) < Math.abs(closestSum - target)){
                    closestSum = currentSum;
                }
                if(currentSum > target){
                   right--;
                }else if(currentSum < target){
                    left++;
                }else{
                    return target;
                }
            }
        }
        return closestSum;
    }
}