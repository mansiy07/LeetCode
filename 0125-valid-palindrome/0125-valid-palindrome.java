class Solution {
    public boolean isAlphaNum(char ch) {
        if ((ch >= '0' && ch <= '9') ||
            (Character.toLowerCase(ch) >= 'a' && Character.toLowerCase(ch) <= 'z')) {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int st = 0;
        int end = s.length() - 1;
        while (st < end) {
            char left = s.charAt(st);
            char right = s.charAt(end);
            if (!isAlphaNum(left)) {
                st++;
                continue;
            }
            if (!isAlphaNum(right)) {
                end--;
                continue;
            }
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}