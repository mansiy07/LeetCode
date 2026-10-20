class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] prev = result.get(result.size()-1);
            int[] curr = intervals[i];
            if(curr[0]<=prev[1]) {
                prev[1] = Math.max(prev[1],curr[1]);
            } else{
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}