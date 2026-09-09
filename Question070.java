// 215. Kth Largest Element in an Array
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Can you solve it without sorting?


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        
        //first k element
        for(int i=0; i<k; i++){
            pq.offer(nums[i]);
        }
        // Remaining element
        for(int i=k; i<nums.length; i++){
            if(nums[i] <= pq.peek()){
                continue;
            }
            pq.poll();
            pq.offer(nums[i]);
        }
        return pq.peek();
    }
}