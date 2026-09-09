class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : order.toCharArray()) {
            int count = freq[ch - 'a'];
            while (count > 0) {
                ans.append(ch);
                count--;
            }
            freq[ch - 'a'] = 0;
        }
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        return ans.toString();
    }
}