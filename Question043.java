// 20. Valid Parentheses
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.


class Solution {
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
                continue;
            }
            //Closing
            if(st.isEmpty()){
                return false;
            }
            if((st.peek() == '(' && s.charAt(i) == ')') || (st.peek() == '[' && s.charAt(i) == ']') || (st.peek() == '{' && s.charAt(i) == '}') ){
                st.pop();
                continue;
            }else{
                return false;
            }
        }
            if(!st.isEmpty()){
            return false;
        }
        return true;   
        }
    }

