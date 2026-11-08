import java.util.*;
public class Find_pivot_index_rotated_sorted_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[nums.length - 1]) {  // we are in the right half. move to left half
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        System.out.println(start);
    }
}
