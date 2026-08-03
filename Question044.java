// 739. Daily Temperatures
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<Integer>st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty()  && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek() - i;
            }
          st.push(i);
        }
        return ans;
    }
}