// 1186. Maximum Subarray Sum with One Deletion
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

// Note that the subarray needs to be non-empty after deleting one element.


class Solution {
    public int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;
        int result = arr[0];

        for(int i=1; i<arr.length; i++){
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;

            noDelete = Math.max(prevNoDelete + arr[i] , arr[i]);
            
            int v2;
            if(prevOneDelete == Integer.MIN_VALUE){
                v2 = arr[0];
            }
            else {
                v2 = prevOneDelete + arr[i];
            }
            oneDelete = Math.max(v2, prevNoDelete);

            result = Math.max(result , Math.max(noDelete , oneDelete));
        }
        return result;
    }
}

