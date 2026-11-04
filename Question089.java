// 17. Letter Combinations of a Phone Number
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


class Solution {

    HashMap<Character,String>digitToLetters = new HashMap<>();
    ArrayList<String>res = new ArrayList<>();

    void fun(String s, int n, int idx, StringBuilder dairy){
        if(idx == n){
            res.add(dairy.toString());
            return;
        }

        String choice  = digitToLetters.get(s.charAt(idx));

        for(int j=0; j<choice.length(); j++){
            dairy.append(choice.charAt(j));

            fun(s,n,idx+1,dairy);

            dairy.deleteCharAt(dairy.length() - 1);
        }
        return;
    }

    public List<String> letterCombinations(String digits) {
        digitToLetters.put('2',"abc");
        digitToLetters.put('3',"def");
        digitToLetters.put('4',"ghi");
        digitToLetters.put('5',"jkl");
        digitToLetters.put('6',"mno");
        digitToLetters.put('7',"pqrs");
        digitToLetters.put('8',"tuv");
        digitToLetters.put('9',"wxyz");

        if(digits.length() == 0){
            return res;
        }
        int n = digits.length();
        int idx =0;

        StringBuilder dairy = new StringBuilder();

        fun(digits, n, idx, dairy);
        return res;

    }
}