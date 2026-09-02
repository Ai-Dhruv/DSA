// 378. Kth Smallest Element in a Sorted Matrix
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

// Note that it is the kth smallest element in the sorted order, not the kth distinct element.

// You must find a solution with a memory complexity better than O(n2).


class Solution {

    public int func(int[][] a, int n, int m, int guess){
        int row = n-1;
        int col = 0;
        int count = 0;;

        while(row>=0 && col<m){
            if(a[row][col] <= guess){
                count = count + row + 1;
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int res = -1;

        while(low <= high){
            int guess = (low + high)/2;

            int ans = func(matrix,n,m,guess);
            if(ans < k){
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