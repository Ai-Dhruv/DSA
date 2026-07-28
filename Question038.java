// 986. Interval List Intersections
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

// Return the intersection of these two interval lists.

// A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

// The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].


class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]>res = new ArrayList<>();

        int n = firstList.length;
        int m = secondList.length;
        int i = 0;
        int j = 0;

        while(i<n && j<m){
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            if(start1 <= start2){
                if(end1 >= start2){
                    int s = Math.max(start1,start2);
                    int e = Math.min(end1,end2);

                    res.add(new int[]{s,e});
                }
            }
            else{// start2<start1
                if(end2 >= start1){
                    int s = Math.max(start1,start2);
                    int e = Math.min(end1,end2);

                    res.add(new int[]{s,e});
                }
            }

            if(end1 <= end2){
                i++;
            }
            else{
                j++;
            }
        }
         return res.toArray(new int[res.size()][]);
    }
}

 