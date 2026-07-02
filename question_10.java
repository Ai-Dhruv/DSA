// 904. Fruit Into Baskets
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

// You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

// You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
// Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
// Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
// Given the integer array fruits, return the maximum number of fruits you can pick.

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int low = 0;
        int res = 0;
        
        for (int high = 0; high < n; high++) {
            freq.put(fruits[high],freq.getOrDefault(fruits[high], 0) + 1);
            // window me 2 se zyada fruit types aa gaye
            while (freq.size() > 2) {
                freq.put(fruits[low],freq.get(fruits[low]) - 1);

                if (freq.get(fruits[low]) == 0) {
                    freq.remove(fruits[low]);
                }
                low++;
            }
            // valid window (at most 2 types)
            int len = high - low + 1;
            res = Math.max(res, len);
        }
        return res;
    }
}
