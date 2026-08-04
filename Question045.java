// 503. Next Greater Element II
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans [] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-2; i>=0; i--){
            st.push(nums[i]);
        }
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }
             if(st.isEmpty()){
            ans[i] = -1;
        }
        else{
            ans[i] = st.peek();
        }
        st.push(nums[i]);
        }
       return ans;
    }
}
