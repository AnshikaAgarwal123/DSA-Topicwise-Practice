//Aggressive Cows
//Input: arr[] = [1, 2, 4, 8, 9], k = 3
// Output: 3
// Explanation: The first cow can be placed at arr[0], the second at arr[2], and the third at arr[3]. The minimum distance between any two cows is 3 (between arr[0] and arr[2]), which is the maximum possible among all valid arrangements.
import java.util.Arrays;

public class Aggressive_cows {
    static boolean isvalidans(int arr[], int k, int mind) {
        int cowno = 1;
        int lastindex = 0;
        for (int i = 1; i < arr.length; i++) {
            int distance = arr[i] - arr[lastindex];
            if (distance >= mind) {
                cowno++;
                lastindex = i;
            }
            if (cowno == k) {
                return true;
            }
        }
        return false;
    }

    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int start = 0;
        int ans = 0;
        int end = arr[arr.length - 1] - arr[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isvalidans(arr, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Aggressive_cows sol = new Aggressive_cows();
        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;
        
        int result = sol.aggressiveCows(stalls, cows);
        System.out.println("Maximum minimum distance: " + result);
    }
}
