// 34. Find First and Last Position of Element in Sorted Array
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.




class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums,target);
        int last = lastOccurrence(nums,target);

        return new int[]{first,last};
    }

    // first Occurrence 
    public int firstOccurrence(int[]arr, int x){
        int low = 0;
        int high = arr.length - 1;
        int res = -1;

        while(low<=high){
            int guess = (low + high)/2;

            if(arr[guess] < x){
                low = guess + 1;
            }else if(arr[guess] > x){
                high = guess - 1;
            }else{
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }
            // last Occurrence 

        public int lastOccurrence(int[]arr, int x){
        int low = 0;
        int high = arr.length - 1;
        int res = -1;

        while(low<=high){
            int guess = (low + high)/2;

            if(arr[guess] < x){
                low = guess + 1;
            }else if(arr[guess] > x){
                high = guess - 1;
            }else{
                res = guess;
                low = guess + 1;
            }
        }
        return res;
    }

}