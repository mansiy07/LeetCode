import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {

            Set<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            for (int num : set) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                ans = Math.max(ans, entry.getKey());
            }
        }
        return ans;
    }
}