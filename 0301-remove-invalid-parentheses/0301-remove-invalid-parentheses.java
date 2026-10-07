class Solution {
    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        // Find extra '(' and ')'
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                left++;
            } 
            else if (ch == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        dfs(s, 0, 0, 0, left, right, "");

        return new ArrayList<>(set);
    }

    void dfs(String s, int index, int balance,
             int removed, int leftRem, int rightRem,
             String current) {

        // Invalid
        if (balance < 0) {
            return;
        }

        // End of string
        if (index == s.length()) {

            if (balance == 0 && leftRem == 0 && rightRem == 0) {
                set.add(current);
            }

            return;
        }

        char ch = s.charAt(index);

        // If current character is '('
        if (ch == '(') {

            // Remove '('
            if (leftRem > 0) {
                dfs(s, index + 1, balance,
                    removed + 1,
                    leftRem - 1, rightRem,
                    current);
            }

            // Keep '('
            dfs(s, index + 1, balance + 1,
                removed,
                leftRem, rightRem,
                current + ch);
        }

        // If current character is ')'
        else if (ch == ')') {

            // Remove ')'
            if (rightRem > 0) {
                dfs(s, index + 1, balance,
                    removed + 1,
                    leftRem, rightRem - 1,
                    current);
            }

            // Keep ')' only when balance > 0
            if (balance > 0) {
                dfs(s, index + 1, balance - 1,
                    removed,
                    leftRem, rightRem,
                    current + ch);
            }
        }

        // Normal character
        else {
            dfs(s, index + 1, balance,
                removed,
                leftRem, rightRem,
                current + ch);
        }
    }
}