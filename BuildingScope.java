import java.util.*;

public class BuildingScope {
    public int[] findBuilding (int[] heights) {
        // write code here
        int n=heights.length;
        int[] ans =new int[n];
        Arrays.fill(ans,1);
        for(int i=0; i<n; i++){
            int left = i-1, right=i+1;
            int leftmax=0, rightmax=0;
            while(left>=0){
                if(heights[left]>leftmax){
                    leftmax=heights[left];
                    ans[i]++;
                }
                left--;
            }
            while(right<n){
                if(heights[right]>rightmax){
                    rightmax=heights[right];
                    ans[i]++;
                }
                right++;
            }
        }

        return ans;
    }
}
