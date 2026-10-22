// 767. Reorganize String
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

// Return any possible rearrangement of s or return "" if not possible.

class Solution {
    class Pair {
        int first;
        char second;

        Pair(int first, char second){
            this.first = first;
            this.second = second;
        }
    }
    public String reorganizeString(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.first - a.first
        );
        for (char ch : map.keySet()){
            pq.add(new Pair(map.get(ch), ch));
        }
        
        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            // First element ya last character different hai
            if (res.length() == 0 || res.charAt(res.length() - 1) != p.second){
                res.append(p.second);
                p.first--;

                if (p.first > 0) {
                    pq.add(p);
                }

            } else{
                // Top element same hai, second character lenge
                if (pq.isEmpty()) {
                    return "";
                }
                Pair p1 = pq.poll();
                res.append(p1.second);
                p1.first--;

                if (p1.first > 0) {
                    pq.add(p1);
                }
                // p ko wapas heap mein daalna hai
                pq.add(p);
            }
        }
        return res.toString();

    }


}