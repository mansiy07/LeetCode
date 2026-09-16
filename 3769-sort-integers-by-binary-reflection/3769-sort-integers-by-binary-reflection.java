import java.util.*;
class Solution {
    public int[] sortByReflection(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            int ra = reflect(a);
            int rb = reflect(b);
            if (ra != rb)
                return Integer.compare(ra, rb);
            return Integer.compare(a, b);
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }
    static int reflect(int n) {
        int rev = 0;
        while (n > 0) {
            rev = (rev << 1) | (n & 1);
            n >>= 1;
        }
        return rev;
    }
}