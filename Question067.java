// 668. Kth Smallest Number in Multiplication Table
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).

// Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.


class Solution {
    public int func(int m, int n, int guess){
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(guess / i, n);
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k){

        int low = 1;
        int high = m * n;
        int ans = -1;

        while (low <= high){

            int mid = low + (high - low)/ 2;
            int count = func(m, n, mid);
            if (count < k){
                low = mid + 1;
            }
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}