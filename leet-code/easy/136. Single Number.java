import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                numMap.remove(num);
            } else {
                numMap.put(num, num);
            }
        }

        return numMap.keySet().iterator().next();
    }
}

// https://leetcode.com/problems/single-number/submissions/1656774704/