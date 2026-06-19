// 977. Squares of a Sorted Array
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;

        }
       int i = 0;
       for(int j=1; j<n ; j++){
        if(nums[i] != nums[j]){
            i++;
            nums[i] = nums[j];
        }
       }
        return i+1;
    }
    
}