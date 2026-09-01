// 240. Search a 2D Matrix II
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = n-1;
        int cols = 0;

        while(row >= 0 && cols < m){
            if(matrix[row][cols] == target){
                return true;
            }
            if(matrix[row][cols] > target){
                row--;
            }
            else{
                cols++;
            }
        }
        return false;
    }
}