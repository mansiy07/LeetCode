class Solution {
    public String sortVowels(String s) {

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int[] freq = new int[5];
        int[] first = new int[5];

        // Initialize first occurrence
        for (int i = 0; i < 5; i++) {
            first[i] = Integer.MAX_VALUE;
        }

        // Count frequency and first occurrence
        for (int i = 0; i < s.length(); i++) {

            int idx = getIndex(s.charAt(i));

            if (idx != -1) {
                freq[idx]++;

                if (first[idx] == Integer.MAX_VALUE) {
                    first[idx] = i;
                }
            }
        }

        // Sort vowels:
        // 1. Frequency descending
        // 2. First occurrence ascending
        for (int i = 0; i < 4; i++) {

            for (int j = i + 1; j < 5; j++) {

                if (freq[j] > freq[i] ||
                   (freq[j] == freq[i] && first[j] < first[i])) {

                    // Swap frequency
                    int tempFreq = freq[i];
                    freq[i] = freq[j];
                    freq[j] = tempFreq;

                    // Swap first occurrence
                    int tempFirst = first[i];
                    first[i] = first[j];
                    first[j] = tempFirst;

                    // Swap vowel
                    char tempVowel = vowels[i];
                    vowels[i] = vowels[j];
                    vowels[j] = tempVowel;
                }
            }
        }

        char[] ans = s.toCharArray();

        int index = 0;

        // Put sorted vowels back
        for (int i = 0; i < ans.length; i++) {

            if (isVowel(ans[i])) {

                ans[i] = vowels[index];

                freq[index]--;

                if (freq[index] == 0) {
                    index++;
                }
            }
        }

        return new String(ans);
    }

    private int getIndex(char c) {

        switch (c) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }

    private boolean isVowel(char c) {
        return c == 'a' ||
               c == 'e' ||
               c == 'i' ||
               c == 'o' ||
               c == 'u';
    }
}