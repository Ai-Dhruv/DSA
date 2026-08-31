// 74. Search a 2D Matrix
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = (n*m) - 1;

        while(low <= high){
            int guess = (low + high)/2;

            int row = guess/m;
            int cols = guess % m;

            if(matrix[row][cols] == target){
                return true;
            }
            if(matrix[row][cols] < target){
                low = guess + 1;
            }
            else{
                high = guess - 1;
            }
        }
        return false; 
    }
}