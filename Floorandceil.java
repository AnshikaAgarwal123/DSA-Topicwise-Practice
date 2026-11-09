//899. Floor and Ceil in Sorted Array
//Example 1:
// Input : nums =[3, 4, 4, 7, 8, 10], x= 5
// Output: 4 7
// Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.
import java.util.Arrays;
import java.util.Scanner;

public class Floorandceil {

    public static int[] getFloorAndCeil(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int ceil = -1;
        int[] arr = new int[2];
        
        // Find Ceil (smallest element >= x)
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= x) {
                ceil = nums[mid];
                end = mid - 1; // Look for a smaller element on the left
            } else {
                start = mid + 1;
            }
        }

        // Find Floor (greatest element <= x)
        start = 0;
        end = nums.length - 1;
        int floor = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= x) {
                floor = nums[mid];
                start = mid + 1; // Look for a larger element on the right
            } else {
                end = mid - 1;
            }
        }
        
        arr[0] = floor;
        arr[1] = ceil;
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Binary search requires a sorted array
        Arrays.sort(nums);
        System.out.println("Array sorted automatically: " + Arrays.toString(nums));

        System.out.print("Enter the target value (x): ");
        int x = scanner.nextInt();

        // Function call
        int[] result = getFloorAndCeil(nums, x);

        // Output results
        System.out.println("\n--- Results ---");
        System.out.println("Floor of " + x + " = " + result[0]);
        System.out.println("Ceil of " + x + " = " + result[1]);

        scanner.close();
    }
}
