// 383. Ransom Note
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> have = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();

        for(int i=0; i<ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        for(int i=0; i<magazine.length(); i++){
            char ch = magazine.charAt(i);
            have.put(ch,have.getOrDefault(ch,0)+1);
        }
        return fun(have,need);
    }
    public boolean fun(HashMap<Character,Integer>have , HashMap<Character,Integer>need){
        for(Character c : need.keySet()){
            int fneed = need.get(c);
            int fhave = have.getOrDefault(c,0);

            if(fhave < fneed){
                return false;
            }
        }
        return true;
    }
}