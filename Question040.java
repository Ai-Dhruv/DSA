// 344. Reverse String
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.


import java.util.Stack;
class Solution{
    public void reverseString(char[] s){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length; i++){
            st.push(s[i]);
        }
        int i = 0;
        while (!st.isEmpty()){
            char c = st.peek();
            st.pop();
            s[i] = c;
            i++;
        }
    }
}