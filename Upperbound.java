import java.util.Scanner;

public class Upperbound {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int nums[]= new int[n];
        for(int i=0; i<n; i++){
            nums[i]= sc.nextInt();
        }
        int target= sc.nextInt();
        int start=0;
        int end= nums.length-1;
        int ans=n;
        while(start<=end){
            int mid=start+ (end-start)/2;
            if(nums[mid]>target){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        System.out.println(ans);
    }
}
//It is used to find > target
//for the edge case we have inittialize the ans as length