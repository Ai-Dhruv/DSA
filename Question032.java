// 974. Subarray Sums Divisible by K
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

// A subarray is a contiguous part of an array.



import java.util.HashMap;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>f = new HashMap<>();
        int n = nums.length;
        int res = 0;
        int sum = 0;

        f.put(0,1);

        for(int i=0; i<n; i++){
            sum += nums[i];
            int rem = sum % k;

            if(rem < 0){
                rem = rem + k;    
            }
            res +=f.getOrDefault(rem,0);
            f.put(rem,f.getOrDefault(rem,0)+1);
        }
        return res;
    }
}