// 1189. Maximum Number of Balloons
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

// You can use each character in text at most once. Return the maximum number of instances that can be formed.

 
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> have = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> need = new HashMap<>();
        need.put('b', 1);
        need.put('a', 1);
        need.put('l', 2);
        need.put('o', 2);
        need.put('n', 1);

        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {

            char c = entry.getKey();
            int fneed = entry.getValue();
            int fhave = have.getOrDefault(c, 0);

            int times = fhave / fneed;

            res = Math.min(res, times);
        }
        return res;
    }
}