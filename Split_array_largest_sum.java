//410. Split Array Largest Sum
// //Example 1:
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
import java.util.Scanner;

class Split_array_largest_sum {
    public static boolean isvalid(int[] nums, int k, int max){
        int painterno = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            int time = nums[i];
            if(nums[i] > max){
                return false;
            }
            else if((nums[i] + sum) <= max){
                sum += nums[i];
            }
            else{
                painterno++;
                sum = nums[i];
            }
        }
        if(painterno <= k){
            return true;
        }
        else{
            return false;
        }
    }

    public int Split_array_largest_sum(int[] nums, int k) {
        if(nums.length < k){
            return -1;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int start = 0;
        int end = sum;
        int finalans = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isvalid(nums, k, mid)){
                finalans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return finalans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter k (number of subarrays): ");
        int k = scanner.nextInt();

        Split_array_largest_sum sol = new Split_array_largest_sum();
        int result = sol.Split_array_largest_sum(nums, k);

        System.out.println("The minimized largest split sum is: " + result);

        scanner.close();
    }
}
