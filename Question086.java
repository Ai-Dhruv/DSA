// 136. Single Number
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.


class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for(int i=0; i<n; i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
}