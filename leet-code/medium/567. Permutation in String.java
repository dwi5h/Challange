import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        return isPermutaion(s1, s2);
    }

    private boolean isPermutaion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap();
        Map<Character, Integer> window = new HashMap();

        for(char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int k = s1.length();
        
        for(int i = 0; i < k; i++) {
            char c = s2.charAt(i);
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        for(int i = k; i < s2.length(); i++) {
            if(s1Map.equals(window)) {
                return true;
            }

            char rightChar = s2.charAt(i);
            char leftChar = s2.charAt(left++);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            window.put(leftChar, window.get(leftChar) - 1);
            if(window.getOrDefault(leftChar, 0) == 0) {
                window.remove(leftChar);
            }
        }

        if(s1Map.equals(window)) {
            return true;
        }

        return false;
    }
}

// https://leetcode.com/problems/permutation-in-string/