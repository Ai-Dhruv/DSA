
// Code
// Testcase
// Testcase
// Test Result
// 643. Maximum Average Subarray I
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// You are given an integer array nums consisting of n elements, and an integer k.

// Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        double ans = 0;
        double window = 0;
        for(int i = 0; i<k ; i++){
            window += nums[i];
        }

        ans = window/k;
        for(int high = k; high<n ; high++){
            window += nums[high] - nums[high-k];
            ans = Math.max(ans , window/k);
        }
        return ans;
    }
}