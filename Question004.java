// 3. Longest Substring Without Repeating Characters
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given a string s, find the length of the longest substring without duplicate characters.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> freq = new HashMap<>();

        int low = 0;
        int res = 0;
        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // duplicate character present

            while (freq.get(ch) > 1) {

                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                low++;
            }
            int len = high - low + 1;
            res = Math.max(res, len);
        } 
        return res;
        
    }
}