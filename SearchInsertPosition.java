import java.util.Arrays;

public class SearchInsertPosition {
    public static int searchInsertPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        // Test cases matching the LeetCode examples
        int[] nums = {1, 3, 5, 6};
        
        int target1 = 5; // Expected output: 2
        int target2 = 2; // Expected output: 1
        int target3 = 7; // Expected output: 4
        int target4 = 0; // Expected output: 0

        System.out.println("Array: " + Arrays.toString(nums));
        // Fixed method name to match searchInsertPosition()
        System.out.println("Target " + target1 + " -> Insert Index: " + searchInsertPosition(nums, target1));
        System.out.println("Target " + target2 + " -> Insert Index: " + searchInsertPosition(nums, target2));
        System.out.println("Target " + target3 + " -> Insert Index: " + searchInsertPosition(nums, target3));
        System.out.println("Target " + target4 + " -> Insert Index: " + searchInsertPosition(nums, target4));
    }
}
