import java.util.*;
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }      
        StringBuilder ans = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inside = false;  
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                inside = true;
                key.setLength(0);
            } 
            else if (ch == ')') {
                String k = key.toString();
                if (map.containsKey(k)) {
                    ans.append(map.get(k));
                } else {
                    ans.append("?");
                }
                inside = false;
            } 
            else if (inside) {
                key.append(ch);
            } 
            else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}