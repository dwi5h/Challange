import java.util.Map;
import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> indexChar = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            indexChar.put(s.charAt(i), indexChar.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (indexChar.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}

// https://leetcode.com/problems/first-unique-character-in-a-string