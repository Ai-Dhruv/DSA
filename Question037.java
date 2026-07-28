
// 57. Insert Interval
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

// Note that you don't need to modify intervals in-place. You can make a new array and return it.


import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arr = new ArrayList<>();
        boolean inserted = false;
        // Insert new interval in sorted order
        for (int i = 0; i < intervals.length; i++) {
            if (!inserted && newInterval[0] <= intervals[i][0]) {
                arr.add(newInterval);
                inserted = true;
            }
            arr.add(intervals[i]);
        }
        if (!inserted) {
            arr.add(newInterval);
        }
        // Merge intervals
        ArrayList<int[]> res = new ArrayList<>();
        int start1 = arr.get(0)[0];
        int end1 = arr.get(0)[1];
        for (int i = 1; i < arr.size(); i++) {
            int start2 = arr.get(i)[0];
            int end2 = arr.get(i)[1];

            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
            } else {
                res.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }
        res.add(new int[]{start1, end1});

        return res.toArray(new int[res.size()][]);
    }
}


