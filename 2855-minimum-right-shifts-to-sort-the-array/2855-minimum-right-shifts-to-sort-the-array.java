class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        
        int n = nums.size();
        int count = 0;
        int index = -1;

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                count++;
                index = i;
            }
        }

        // Check circular pair: last element -> first element
        if (nums.get(n - 1) > nums.get(0)) {
            count++;
            index = n - 1;
        }

        if (count > 1) {
            return -1;
        }

        if (count == 0) {
            return 0;
        }

        return n - 1 - index;
    }
}