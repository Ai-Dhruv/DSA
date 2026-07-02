// 977. Squares of a Sorted Array
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
import java.util.*;
 class Solution {
    public int[] sortedSquares(int[] nums) {

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // Separate negative and positive numbers
        for (int num : nums) {
            if (num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        // Case 1: No negative numbers
        if (neg.size() == 0) {
            int[] res = new int[pos.size()];

            for (int i = 0; i < pos.size(); i++) {
                res[i] = pos.get(i) * pos.get(i);
            }

            return res;
        }

        // Case 2: No positive numbers
        if (pos.size() == 0) {
            int[] res = new int[neg.size()];

            for (int i = 0; i < neg.size(); i++) {
                neg.set(i, neg.get(i) * neg.get(i));
            }

            Collections.reverse(neg);

            for (int i = 0; i < neg.size(); i++) {
                res[i] = neg.get(i);
            }

            return res;
        }

        // Case 3: Both negative and positive exist

        // Square negatives
        for (int i = 0; i < neg.size(); i++) {
            neg.set(i, neg.get(i) * neg.get(i));
        }

        // Reverse negatives
        Collections.reverse(neg);

        // Square positives
        for (int i = 0; i < pos.size(); i++) {
            pos.set(i, pos.get(i) * pos.get(i));
        }

        // Merge two sorted lists
        int n1 = neg.size();
        int n2 = pos.size();

        int[] res = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < n1 && j < n2) {
            if (neg.get(i) <= pos.get(j)) {
                res[idx++] = neg.get(i++);
            } else {
                res[idx++] = pos.get(j++);
            }
        }

        while (i < n1) {
            res[idx++] = neg.get(i++);
        }

        while (j < n2) {
            res[idx++] = pos.get(j++);
        }

        return res;
    }
}
