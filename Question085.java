// 217. Contains Duplicate
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer>set = new HashSet<>();

        for(int i=0; i<n; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}