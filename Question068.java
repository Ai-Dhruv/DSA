// 162. Find Peak Element
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

// You must write an algorithm that runs in O(log n) time.


class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        if(nums[0] > nums[1])  return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int low = 1;
        int high = n-2;

        while(low <= high){
            int guess = (low + high)/2;

            if(nums[guess] > nums[guess-1] && nums[guess] > nums[guess+1]){
                return guess;
            }
            else if(nums[guess] > nums[guess - 1]){
                low = guess + 1;
            }
            else{
                high = guess - 1;
            }
        }
        return -1;
    }
}