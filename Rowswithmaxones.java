//Return the index of the row with maximum number of ones (All the rows are sorted in ascending order)
public class Rowswithmaxones {
    static int getfirstoccurence(int[][] mat, int i){
        int start=0;
        int end=mat[0].length-1;
        int ans=mat[0].length;
        while(start<=end){
        int mid=start+(end-start)/2;
        if(mat[i][mid]==1){
            ans= mid;
            end=mid-1;
        }
        else{
            start=mid+1;
        }
    }
        return ans;
    }
    public static void main(String[] args) {
        int[][] mat = {
            {0, 0, 1, 1},
            {0, 1, 1, 1},
            {0, 0, 0, 1}
        };
        int ans=0;
        int max=0;
        for(int i=0; i<mat.length; i++){
            int onescount= mat[0].length- getfirstoccurence(mat,i);
            if(onescount>max){
                max= onescount;
                ans=i;
            }
        }
        System.out.println(ans);
    }
}
