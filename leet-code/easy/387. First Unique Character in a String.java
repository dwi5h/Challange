import java.util.Map;
import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> indexCharPermanent = new HashMap<>();
        Map<Character, Integer> indexChar = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (indexCharPermanent.containsKey(s.charAt(i))) {
                if (indexChar.containsKey(s.charAt(i))) {
                    indexChar.remove(s.charAt(i));
                }
            } else {
                indexChar.put(s.charAt(i), i);
            }

            indexCharPermanent.put(s.charAt(i), i);
        }

        if (indexChar.size() == 0) {
            return -1;
        }

        int index = indexChar.entrySet().iterator().next().getValue();
        int min = index;
        for (Map.Entry<Character, Integer> entry : indexChar.entrySet()) {
            min = Math.min(min, entry.getValue());
        }
        return min;
    }
}