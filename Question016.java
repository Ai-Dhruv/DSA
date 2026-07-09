// 76. Minimum Window Substring
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.


class Solution {
    public boolean fun(int[]have, int[]need){
        for(int i = 0; i < 256; i++){
            if(have[i] < need[i]){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n<m){
            return "";
        }
        
        int[]have = new int[256];
        int[]need = new int[256];

        for(int i = 0; i < m; i++){
            need[t.charAt(i)]++;

        }
        int low = 0;
        int res = Integer.MAX_VALUE;
        int start = -1;
        for(int high = 0; high < n; high++){
            have[s.charAt(high)]++;

            while(fun(have,need)){
                int len = high - low +1;
                if(len < res){
                    res = len;
                    start = low;
                }
                have[s.charAt(low)]--;
                low++;
            }
        }
        if(res == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start + res);
    }
}