// 692. Top K Frequent Words
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an array of strings words and an integer k, return the k most frequent strings.

// Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        int n = words.length;

        // Make HashMap
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // Min heap -> pair -> freq, word
        PriorityQueue<Pair<Integer, String>> pq =
            new PriorityQueue<>((a, b) -> {

                // Different frequency
                if (!a.getKey().equals(b.getKey())) {
                    return a.getKey() - b.getKey();
                }

                // Same frequency -> lexicographically larger first
                return b.getValue().compareTo(a.getValue());
            });

        // Add HashMap to Heap
        for (Map.Entry<String, Integer> i : map.entrySet()) {

            String word = i.getKey();
            int freq = i.getValue();

            Pair<Integer, String> curr =
                new Pair<>(freq, word);

            if (pq.size() < k) {
                pq.add(curr);
                continue;
            }

            // Current word is worse than heap top
            if (curr.getKey() < pq.peek().getKey()) {
                continue;
            }

            // Same frequency and current word is lexicographically larger
            if (curr.getKey().equals(pq.peek().getKey()) &&
                curr.getValue().compareTo(pq.peek().getValue()) > 0) {
                continue;
            }

            // Remove worst and add current
            pq.poll();
            pq.add(curr);
        }

        // Result
        List<String> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getValue());
        }

        return res;
    }
}