import java.util.*;
public class Getlowerbound{
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
            int mid= start+ (end-start)/2;
            if(nums[mid]>=target){
                ans= mid;
                end= mid-1;
            }
            else{
                start= mid+1;
            }
        }
        System.out.println(start);
    }
}
//lower bound is the first index >=target
//upper bound is the first index > target