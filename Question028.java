// 1749. Maximum Absolute Sum of Any Subarray
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

// Return the maximum absolute sum of any (possibly empty) subarray of nums.

// Note that abs(x) is defined as follows:

// If x is a negative integer, then abs(x) = -x.
// If x is a non-negative integer, then abs(x) = x.

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];

        for(int i=1; i<n; i++){
            // MAX SUBARRAY
            int v1 = maxEnding + nums[i];
            int v2 = nums[i];

            maxEnding = Math.max(v1,v2);
            maxSum = Math.max(maxSum , maxEnding);

            //MIN SUBARRAY
            int v3 = minEnding + nums[i];
            int v4 = nums[i];

            minEnding = Math.min(v3,v4);
            minSum = Math.min(minSum , minEnding);
        }

        return Math.max(Math.abs(maxSum) , Math.abs(minSum));
    }
}