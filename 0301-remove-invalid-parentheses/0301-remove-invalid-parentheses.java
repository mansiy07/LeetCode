class Solution {
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
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
        if (balance < 0) {
            return;
        }
        if (index == s.length()) {
            if (balance == 0 && leftRem == 0 && rightRem == 0) {
                set.add(current);
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            if (leftRem > 0) {
                dfs(s, index + 1, balance,
                    removed + 1,
                    leftRem - 1, rightRem,
                    current);
            }
            dfs(s, index + 1, balance + 1,
                removed,
                leftRem, rightRem,
                current + ch);
        }
        else if (ch == ')') {
            if (rightRem > 0) {
                dfs(s, index + 1, balance,
                    removed + 1,
                    leftRem, rightRem - 1,
                    current);
            }
            if (balance > 0) {
                dfs(s, index + 1, balance - 1,
                    removed,
                    leftRem, rightRem,
                    current + ch);
            }
        }
        else {
            dfs(s, index + 1, balance,
                removed,
                leftRem, rightRem,
                current + ch);
        }
    }
}