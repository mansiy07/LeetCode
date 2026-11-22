class Solution {
    public String minWindow(String s,String t) {
        if(s.length()<t.length()) return "";
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int i=0,j=0,count=t.length();
        int minLen=Integer.MAX_VALUE;
        int start=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch)>0){
                    count--;
                }
                map.put(ch,map.get(ch)-1);
            }
            while(count==0){
                if(j-i+1<minLen){
                    minLen=j-i+1;
                    start=i;
                }
                char left=s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left)>0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        if(minLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+minLen);
    }
}