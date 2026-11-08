// class Solution {
//     int dp[][][];
//     public int wiggleMaxLength(int[] nums){
//         int n=nums.length;
//         dp=new int[n][n+1][3];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<=n;j++){
//                 Arrays.fill(dp[i][j],-1);
//             }
//         }
//         return fxn(nums,0,-1,2);
//     }
//     public int fxn(int nums[],int i,int prev,int direction){
//         if(i==nums.length) return 0;
//         if(dp[i][prev+1][direction]!=-1){
//             return dp[i][prev+1][direction];
//         }
//         int notTake=fxn(nums,i+1,prev,direction);
//         int take=0;
//         if(prev==-1){
//             take=1+fxn(nums,i+1,i,2);
//         }
//         else if(nums[i]>nums[prev] && direction!=0){
//             take=1+fxn(nums,i+1,i,0);
//         }
//         else if (nums[i]<nums[prev] && direction!=1){
//             take=1+fxn(nums,i+1,i,1);
//         }
//         return dp[i][prev+1][direction]=Math.max(take,notTake);
//     }
// }


// Tabulation

class Solution {
    public int wiggleMaxLength(int[] nums){
        int n=nums.length;
        int dpUp[]=new int[n];
        int dpDown[]=new int[n];
        Arrays.fill(dpUp,1);
        Arrays.fill(dpDown,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dpUp[i]=Math.max(dpUp[i],dpDown[j]+1);
                }
                else if(nums[i]<nums[j]){
                    dpDown[i]=Math.max(dpDown[i],dpUp[j]+1);
                }
            }
        }
        int result=1;
        for(int i=0;i<n;i++){
            result=Math.max(result,Math.max(dpUp[i],dpDown[i]));
        }
        return result;
    }
}