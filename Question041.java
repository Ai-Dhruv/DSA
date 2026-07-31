// 1047. Remove All Adjacent Duplicates In String
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

// We repeatedly make duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.


class Solution {
    public String removeDuplicates(String s) {
        Stack<Character>st = new Stack<>();
        int n = s.length();
        int i = 0 ;
        StringBuilder res = new StringBuilder();

        for(i=0; i<n; i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
                continue;
            }
            if(st.peek() == s.charAt(i)){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }

        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}