// 1337. The K Weakest Rows in a Matrix
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

// A row i is weaker than a row j if one of the following is true:

// The number of soldiers in row i is less than the number of soldiers in row j.
// Both rows have the same number of soldiers and i < j.
// Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.



class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] arr = new int[mat.length][2];
        // Store row index and soldier count
        for (int i = 0; i < mat.length; i++){
            int soldiers = 0;
            for (int j = 0; j < mat[i].length; j++){
                if (mat[i][j] == 1){
                    soldiers++;
                }
            }
            arr[i][0] = i;
            arr[i][1] = soldiers;
        }  

        
        // Sort by soldier count, then by row index
        Arrays.sort(arr, (a, b)  ->  {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
 

        // Store k weakest row indices
        int[] answer = new int[k];
        for (int i = 0; i < k; i++){
            answer[i] = arr[i][0];
        }
        return answer;

    }
}