import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> sSet = new HashSet<>();

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (sSet.contains(c)) {
                sSet.remove(s.charAt(left++));
            }

            sSet.add(c);
            max = Math.max(max, sSet.size());
        }

        return max;
    }
}

// https://leetcode.com/problems/longest-substring-without-repeating-characters/