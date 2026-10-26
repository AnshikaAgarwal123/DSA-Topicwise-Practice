//Leetcode-189. Rotate Array
// Example:
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
//This is the basic approach by making changes in diffrent array
import java.util.*;
public class Rotate_array {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the times you want to rotate an array");
        int k= sc.nextInt();
        System.out.println("Enter the array");
        int n= sc.nextInt();
        int nums[]= new int[n];
        for(int i=0; i<n; i++){
            nums[i]= sc.nextInt();
        }
        if(nums.length==1){
            return;
        }
        int array[]= new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int finalindex= i+k;
            while(finalindex>=nums.length){
                finalindex= finalindex-nums.length;
            }
            array[finalindex]=nums[i];
        }

        for(int i=0; i<nums.length; i++){
            nums[i]=array[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}
