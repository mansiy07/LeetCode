class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (freq.get(c) > 2) {
                char l = s.charAt(left);
                freq.put(l, freq.get(l) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}