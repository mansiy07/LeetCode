class Solution {
    public String sortVowels(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                count[c]++;
            }
        }

        StringBuilder ans = new StringBuilder(s);
        int index = 0;

        for (int c = 0; c < 128; c++) {
            while (count[c] > 0) {

                while (!isVowel(s.charAt(index))) {
                    index++;
                }

                ans.setCharAt(index, (char) c);
                index++;
                count[c]--;
            }
        }

        return ans.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' ||
               c == 'O' || c == 'U';
    }
}