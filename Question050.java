// 409. Longest Palindrome
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome.


class Solution {
    public int longestPalindrome(String s) {
       HashMap<Character,Integer> f = new HashMap<>();

       for(int i =0; i<s.length(); i++){
        char ch = s.charAt(i);
        f.put(ch,f.getOrDefault(ch,0)+1);
       } 
       boolean odd = false;
       int res = 0;

        for(HashMap.Entry<Character,Integer> entry: f.entrySet()){
            int val = entry.getValue();
            if(val % 2 ==0){
                res += val;
            }
            else{
                odd = true;
            }
        }
        if(odd == false){
            return res;
        }
        for(HashMap.Entry<Character,Integer> entry: f.entrySet()){
            int val = entry.getValue();
            if(val % 2 !=0){
                res+=val-1;
            }
        }
        return res+1;
    }
}