// 918. Maximum Sum Circular Subarray
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

// A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

// A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.


class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int maxBestEnding = nums[0];
        int minBestEnding = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int SumOfArray = nums[0];

        for(int i=1; i<n; i++){
            maxBestEnding = Math.max(maxBestEnding + nums[i] , nums[i]);
            minBestEnding = Math.min(minBestEnding + nums[i] , nums[i]);
            maxSum = Math.max(maxBestEnding , maxSum);
            minSum = Math.min(minBestEnding , minSum);

            SumOfArray += nums[i];
        }

        int circularmax = SumOfArray - minSum;

        if(maxSum<0){
            return maxSum;
        }
        return Math.max(maxSum, circularmax);
    }
}


