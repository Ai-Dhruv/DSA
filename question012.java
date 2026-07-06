// 424. Longest Repeating Character Replacement
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.


class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[256];

        int low = 0;
        int res = 0;

        for (int high = 0; high < s.length(); high++) {
            freq[s.charAt(high)]++;

            int len = high - low + 1;
            int maxFreq = 0;
            for (int i = 0; i < 256; i++) {
                maxFreq = Math.max(maxFreq, freq[i]);
            }
            int diff = len - maxFreq;
            while (diff > k) {

                freq[s.charAt(low)]--;
                low++;

                len = high - low + 1;

                maxFreq = 0;
                for (int i = 0; i < 256; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
                diff = len - maxFreq;
            }
            res = Math.max(res,len);
        }
        return res;
    }
}