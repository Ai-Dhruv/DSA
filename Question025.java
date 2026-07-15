
// 53. Maximum Subarray
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an integer array nums, find the subarray with the largest sum, and return its sum.


class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int bestending = nums[0];
        int ans = nums[0];

        for(int i=1; i<n; i++){
            int v1 = bestending + nums[i];
            int v2 = nums[i];

            bestending = Math.max(v1,v2);

            ans = Math.max(ans,bestending);
        }
        return ans;
        
    }
}