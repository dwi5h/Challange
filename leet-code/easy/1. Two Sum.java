import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numsMap.containsKey(nums[i])) {
                numsMap.put(nums[i], i);
            }

            Integer remainIndex = numsMap.get(target - nums[i]);

            if (remainIndex != null && remainIndex != i) {
                int min = Math.min(i, remainIndex);
                int max = Math.max(i, remainIndex);
                return new int[] { min, max };
            }
        }

        return new int[] { 0 };
    }
}

// https://leetcode.com/problems/two-sum/submissions/