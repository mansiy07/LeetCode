class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,Integer> degree=new HashMap<>();
        for(int i=0;i<paths.size();i++){
            String u=paths.get(i).get(0);
            String v=paths.get(i).get(1);
            degree.putIfAbsent(u,0);
            degree.putIfAbsent(v,0);
            degree.put(u,degree.get(u)+1);
        }
        for(String city:degree.keySet()){
            if(degree.get(city)==0){
                return city;
            }
        }
        return "";
    }
}
