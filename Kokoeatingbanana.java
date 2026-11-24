public class Kokoeatingbanana {

    static boolean isValidAns(int[] piles, long h, long k) {
        long hour = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % k == 0) {
                hour += piles[i] / k;
            } else {
                hour += (piles[i] / k) + 1;
            }
        }
        return hour <= h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        long max = -1;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        long start = 1;
        long end = max;
        int ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isValidAns(piles, h, mid)) {
                ans = (int) mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test case
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;

        int result = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed (k): " + result); // Expected output: 4
    }
}
