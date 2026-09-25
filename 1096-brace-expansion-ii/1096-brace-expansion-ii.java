import java.util.*;
class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = solve(expression, 0, expression.length() - 1);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }
    private Set<String> solve(String s, int l, int r) {
        Set<String> result = new HashSet<>();
        result.add("");
        int i = l;
        while (i <= r) {
            Set<String> current = new HashSet<>();
            if (s.charAt(i) == '{') {
                int count = 0;
                int j = i;
                while (j <= r) {
                    if (s.charAt(j) == '{') count++;
                    else if (s.charAt(j) == '}') count--;
                    if (count == 0) break;
                    j++;
                }
                current = parseUnion(s, i + 1, j - 1);
                i = j + 1;
            } else {
                int j = i;
                while (j <= r && Character.isLetter(s.charAt(j))) {
                    j++;
                }
                String word = s.substring(i, j);
                current.add(word);
                i = j;
            }
            Set<String> next = new HashSet<>();
            for (String a : result) {
                for (String b : current) {
                    next.add(a + b);
                }
            }
            result = next;
        }
        return result;
    }
    private Set<String> parseUnion(String s, int l, int r) {
        Set<String> result = new HashSet<>();
        int start = l;
        int depth = 0;
        for (int i = l; i <= r; i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                depth++;
            } 
            else if (ch == '}') {
                depth--;
            } 
            else if (ch == ',' && depth == 0) {
                result.addAll(solve(s, start, i - 1));
                start = i + 1;
            }
        }
        result.addAll(solve(s, start, r));
        return result;
    }
}