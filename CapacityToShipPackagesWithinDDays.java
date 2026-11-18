//1011. Capacity To Ship Packages Within D Days
//Example 1:
// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
// Output: 15
// Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10
// Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

public class CapacityToShipPackagesWithinDDays {

    static boolean isValidAns(int[] weights, int days, long maxcapacity) {
        int day = 1;
        int capacity = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > maxcapacity) {
                return false;
            }

            if (capacity + weights[i] <= maxcapacity) {
                capacity += weights[i];
            } else {
                day++;
                capacity = 0;
                capacity += weights[i];
            }
        }
        return day <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            min = Math.min(min, weights[i]);
            sum += weights[i];
        }
        long start = min;
        long end = sum;
        int ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isValidAns(weights, days, mid)) {
                ans = (int) mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        int result = shipWithinDays(weights, days);
        System.out.println("Minimum capacity to ship within " + days + " days: " + result);
    }
}
