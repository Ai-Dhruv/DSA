// 1209. Remove All Adjacent Duplicates in String II
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

// We repeatedly make k duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.


class Solution {
    class Pair{
        char ch;
        int count;
    Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
        }            
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair>st = new Stack<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(st.isEmpty()){
            st.push(new Pair(c,1));
            continue;
        }
                if(st.peek().ch != c){
                st.push(new Pair(c,1));
                continue;
        }
            if(st.peek().count < k-1){
                Pair p = st.pop();
                st.push(new Pair(p.ch,p.count+1));
                continue;
            }

            st.pop();
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            Pair p = st.pop();
            while(p.count-- > 0){
                res.append(p.ch);
            }
        }
        return res.reverse().toString();
        
    }
}