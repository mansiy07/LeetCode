class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        if (n < target.length()) {
            return "";
        }
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        char[] ans = new char[n];
        int limit = Math.min(n, target.length());
        for (int i = 0; i < limit; i++) {
            int x = target.charAt(i) - 'a';
            if (freq[x] > 0) {
                ans[i] = target.charAt(i);
                freq[x]--;
            } 
            else {
                int big = -1;
                for (int j = x + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        big = j;
                        break;
                    }
                }
                if (big != -1) {
                    ans[i] = (char) ('a' + big);
                    freq[big]--;
                    fillRemaining(ans, i + 1, freq);
                    return new String(ans);
                }
                for (int j = i - 1; j >= 0; j--) {
                    int prev = ans[j] - 'a';
                    freq[prev]++;
                    int next = -1;
                    for (int k = prev + 1; k < 26; k++) {
                        if (freq[k] > 0) {
                            next = k;
                            break;
                        }
                    }
                    if (next != -1) {
                        ans[j] = (char) ('a' + next);
                        freq[next]--;
                        fillRemaining(ans, j + 1, freq);
                        return new String(ans);
                    }
                }
                return "";
            }
        }
        if (n > target.length()) {
            fillRemaining(ans, target.length(), freq);
            return new String(ans);
        }
        for (int i = n - 1; i >= 0; i--) {
            int prev = ans[i] - 'a';
            freq[prev]++;
            int next = -1;
            for (int j = prev + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    next = j;
                    break;
                }
            }
            if (next != -1) {
                ans[i] = (char) ('a'+next);
                freq[next]--;
                fillRemaining(ans, i + 1, freq);
                return new String(ans);
            }
        }
        return "";
    }
    private void fillRemaining(char[] ans, int index, int[] freq) {
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans[index++] = (char) ('a'+i);
                freq[i]--;
            }
        }
    }
}