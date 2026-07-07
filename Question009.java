// 209. Minimum Size Subarray Sum
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length ;
        int low=0;
        int high =0;
        int result = Integer.MAX_VALUE;
        int sum = 0;

        while(high < n){
            sum = sum + arr[high];

            while(sum >= target){
                int len =high -low + 1;
                result = Math.min(result,len);

                sum = sum - arr[low];
                low++;
            }

            high++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}