
// Code
// Testcase
// Testcase
// Test Result
// 1004. Max Consecutive Ones III
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int window = 0;
        int ans = 0;

        for (int high = 0; high < nums.length; high++) {
            window += nums[high];
            int len = high - low + 1;
            
            while ((window + k) < len) {
                window -= nums[low];
                low++;
                len = high - low + 1;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}