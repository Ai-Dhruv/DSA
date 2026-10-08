// 658. Find K Closest Elements
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

// An integer a is closer to x than an integer b if:

// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b



class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while(left < right){
            int guess = (left + right)/2;

            if(x - arr[guess] > arr[guess + k] - x){
                left = guess + 1;
            }
            else{
                right = guess;
            }
        }
        List<Integer>res = new ArrayList<>();

        for(int i=left; i< left+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}