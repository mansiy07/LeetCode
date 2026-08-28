class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int odd = 0;
        char middle = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }
        if (odd > 1) return "";
        int halfLen = s.length() / 2;
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }
        String targetHalf = target.substring(0, halfLen);
        String half = getSmallestGreaterOrEqual(halfFreq, targetHalf);
        if (half == null) return "";
        StringBuilder ans = new StringBuilder();
        ans.append(half);
        if (s.length() % 2 == 1) {
            ans.append(middle);
        }
        ans.append(new StringBuilder(half).reverse());
        String result = ans.toString();
        if (result.compareTo(target) > 0) {
            return result;
        }
        String nextHalf = getNextHalf(halfFreq, targetHalf);
        if (nextHalf == null) return "";
        ans.setLength(0);
        ans.append(nextHalf);
        if (s.length() % 2 == 1) {
            ans.append(middle);
        }
        ans.append(new StringBuilder(nextHalf).reverse());
        return ans.toString().compareTo(target) > 0
                ? ans.toString()
                : "";
    }
    private String getSmallestGreaterOrEqual(int[] freq, String target) {
        int n = target.length();
        int[] cnt = freq.clone();
        StringBuilder exact = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';
            if (cnt[x] == 0) {
                exact = null;
                break;
            }
            exact.append(target.charAt(i));
            cnt[x]--;
        }
        if (exact != null) {
            return exact.toString();
        }
        return getNextHalf(freq, target);
    }
    private String getNextHalf(int[] freq, String target) {
        int n = target.length();
        for (int i = n - 1; i >= 0; i--) {
            int[] cnt = freq.clone();
            boolean possible = true;
            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';
                if (cnt[x] == 0) {
                    possible = false;
                    break;
                }
                cnt[x]--;
            }
            if (!possible) continue;
            int current = target.charAt(i) - 'a';
            for (int c = current + 1; c < 26; c++) {
                if (cnt[c] == 0) continue;
                StringBuilder res = new StringBuilder();
                res.append(target.substring(0, i));
                res.append((char) ('a' + c));
                cnt[c]--;
                for (int k = 0; k < 26; k++) {
                    while (cnt[k] > 0) {
                        res.append((char) ('a' + k));
                        cnt[k]--;
                    }
                }
                return res.toString();
            }
        }
        return null;
    }
}