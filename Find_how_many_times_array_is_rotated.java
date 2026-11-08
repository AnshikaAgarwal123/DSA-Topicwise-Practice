//765. Find out how many times the array is rotated
//Example 1:
// Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
// Output: 4
// Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7]. So, we can notice that the array has been rotated 4 times.
import java.util.ArrayList;
import java.util.Arrays;

class Find_how_many_times_array_is_rotated {
    public int findKRotation(ArrayList<Integer> nums) {
        int start = 0;
        int end = nums.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) > nums.get(end)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Find_how_many_times_array_is_rotated solver = new Find_how_many_times_array_is_rotated();
        
        // Example test case: rotated array [4, 5, 6, 7, 0, 1, 2]
        // The minimum element is 0 at index 4, meaning it was rotated 4 times.
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2));
        
        int result = solver.findKRotation(nums);
        
        System.out.println("Array: " + nums);
        System.out.println("Rotation Count: " + result);
    }
}
