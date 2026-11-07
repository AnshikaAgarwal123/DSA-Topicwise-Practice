//839. Count Occurrences in a Sorted Array
//Example 1:
// Input: arr = [0, 0, 1, 1, 1, 2, 3], target = 1
// Output: 3
// Explanation: The number 1 appears 3 times in the array.
import java.util.Scanner;

public class Count_occureneces_in_a_sorted_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the target element to count: ");
        int target = scanner.nextInt();
        
        //logic for lower and upper bounds
        int start = 0;
        int end = n - 1;
        int lowerbound = -1;
        int upperbound = -1;
        
        // Upper bound calculation
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target || arr[mid] < target) {
                upperbound = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        start = 0;
        end = n - 1;
        
        // Lower bound calculation
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target || arr[mid] > target) {
                lowerbound = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        int result = 0;
        if (upperbound != -1 && lowerbound != -1) {
            result = upperbound - lowerbound + 1;
        }
        
        System.out.println("Total occurrences of " + target + ": " + result);
        
        scanner.close();
    }
}
