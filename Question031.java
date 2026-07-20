// 560. Subarray Sum Equals K
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.


import java.util.HashMap;
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>f = new HashMap<>();

        int sum = 0;
        int res = 0;
        f.put(0,1);

        for(int i=0; i<nums.length; i++ ){
            sum += nums[i];

            int question = sum-k;

            int freq = f.getOrDefault(question,0);

            res += freq;

            f.put(sum,f.getOrDefault(sum,0)+1);
        }
        return res;
    }
}