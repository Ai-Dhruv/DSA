// 1482. Minimum Number of Days to Make m Bouquets
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array bloomDay, an integer m and an integer k.

// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.


class Solution {

    public boolean possible(int[] arr, int day, int m, int k) {

        int cut = 0;
        int noOfBouquets = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= day) {
                cut++;
            } 
            else {
                noOfBouquets += cut / k;
                cut = 0;
            }
        }

        noOfBouquets += cut / k;

        if (noOfBouquets >= m) {
            return true;
        }

        return false;
    }


    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if ((long)m * k > n) {
            return -1;
        }

        int low = 1;
        int high = 0;

        // maximum bloom day
        for (int day : bloomDay) {
            high = Math.max(high, day);
        }

        int res = high;

        while (low <= high) {

            int guess = (low + high) / 2;

            if (possible(bloomDay, guess, m, k)) {

                res = guess;
                high = guess - 1;

            } else {

                low = guess + 1;
            }
        }

        return res;
    }
}