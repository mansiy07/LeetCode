
import java.util.*;

class Solution {
    public int maxEnvelopes(int arr[][]){
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        List<Integer> lis=new ArrayList<>();
        for(int i=0;i<n;i++){
            int height=arr[i][1];
            if(lis.isEmpty() || height>lis.get(lis.size()-1)){
                lis.add(height);
            }else{
                int low=0;
                int high=lis.size()-1;
                while(low<high){
                    int mid=low+(high-low)/2;
                    if(lis.get(mid)>=height){
                        high = mid;
                    }else{
                        low=mid+1;
                    }
                }
                lis.set(low,height);
            }
        }
        return lis.size();
    }
}
