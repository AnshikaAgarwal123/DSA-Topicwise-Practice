//33. Search in Rotated Sorted Array
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
import java.util.*;
public class Search_in_a_rotated_sorted_array{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int nums[]= new int[n];
        for(int i=0; i<n; i++){
            nums[i]= sc.nextInt();
        }
        int target= sc.nextInt();
        int left=0;
        int right= nums.length-1;
        while(left<=right){
            int mid= left+ (right-left)/2;
            if(nums[mid]==target){
                System.out.println(mid);
                return;
            }
            //right part is sorted
            else if(nums[mid]<nums[right]){ 
                if(target>nums[mid] && target<=nums[right]){
                    left= mid+1;
                }
                else{
                    right= mid-1;
                }
            }
            //left part is sorted
            else{
                if(target>= nums[left] && target<nums[mid]){
                    right= mid-1;
                }
                else{
                    left=mid+1;
                }
            }
        }
        System.out.println(-1);
    }
}
