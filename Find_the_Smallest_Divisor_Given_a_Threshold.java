//1283. Find the Smallest Divisor Given a Threshold
//Example 1:
// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
import java.util.Scanner;

class Find_the_Smallest_Divisor_Given_a_Threshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int i=0; i<nums.length; i++){
            max= Math.max(nums[i], max);
        }
        int start=1;
        int end=max;
        int ans=0;
        while(start<=end){
            int mid= start+ (end-start)/2;
            int sum=0;
            for(int i=0; i<nums.length; i++){
                int num=0;
                if(nums[i]%mid==0){
                    num=nums[i]/mid;
                }
                else{
                    num=(nums[i]/mid)+1;
                }
                sum+=num;
                if(sum>threshold){
                    break;
                }
            }
            if(sum<=threshold){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the threshold: ");
        int threshold = scanner.nextInt();
        
        Find_the_Smallest_Divisor_Given_a_Threshold sol = new Find_the_Smallest_Divisor_Given_a_Threshold();
        int result = sol.smallestDivisor(nums, threshold);
        
        System.out.println("The Smallest Divisor is: " + result);
        
        scanner.close();
    }
}
