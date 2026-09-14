// 347. Top K Frequent Elements
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.


class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        // Make HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store frequency
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Make min heap
        // Heap -> pairs -> (frequency, element)

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.frequency - b.frequency
        );

        // Traverse HashMap
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {

            int element = i.getKey();
            int freq = i.getValue();

            Pair curr = new Pair(freq, element);

            // If heap size is less than k
            if (pq.size() < k) {
                pq.offer(curr);
                continue;
            }

            // If current frequency is smaller than minimum
            if (curr.frequency < pq.peek().frequency) {
                continue;
            }

            // Remove minimum frequency
            pq.poll();

            // Push current pair
            pq.offer(curr);
        }

        // Make answer
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().element;
        }

        return res;
    }

    // Pair class
    class Pair {

        int frequency;
        int element;

        Pair(int frequency, int element) {
            this.frequency = frequency;
            this.element = element;
        }
    }
}
    