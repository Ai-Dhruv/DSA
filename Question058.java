// 852. Peak Index in a Mountain Array
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

// Return the index of the peak element.

// Your task is to solve it in O(log(n)) time complexity.

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;

        while(low <= high){
            int guess = (low + high)/2;

            if(arr[guess] < arr[guess + 1]){
                low = guess + 1;
            }
            else{
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }
}