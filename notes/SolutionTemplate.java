package notes;

import java.util.HashMap;
import java.util.Map;

public class SolutionTemplate {
    public static int anagram(String s) {
        if(s.length() % 2 > 0) {
            return -1;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        int mid = s.length() / 2;
        String s1 = s.substring(0, mid);
        String s2 = s.substring(mid, s.length());

        for(char c : s2.toCharArray()) {
            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
        }

        int anagram = 0;
        for(char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
            if(s2Map.containsKey(c) && s1Map.get(c) > s2Map.get(c)) {
                anagram++;
            }
            else if(!s2Map.containsKey(c)) {
                anagram++;
            }
        }

        return anagram;
    }
}
