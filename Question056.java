
// 704. Binary Search
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

// You must write an algorithm with O(log n) runtime complexity.


class Solution {
    public int search(int[] nums, int target) {
        int low= 0;
        int high  = nums.length - 1;

        while(low <= high){
            int guess = low + (high - low) / 2;

            if(nums[guess] == target){
                return guess;
            }
            else if(nums[guess] < target){
                low = guess + 1;
            }
            else{
                high = guess - 1;
            }
        }
        return -1;
    }
}