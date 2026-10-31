//Find the sqrt of the number with precision
//binary search on answers+ for loop
import java.util.*;

public class sqrt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int start = 1;
        int end = x;
        int ans = -1;
        if(x==0){
            System.out.println(0);
            return;
        }
        // for integer answer
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) { // Integer overflow case
                System.out.println(mid);
                return;
            } else if (mid < x / mid) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("Integer answer is" + ans);

        // for decimal answer
        double factor = 1.0;
        double newans = ans;
        double finalans = ans;
        for (int i = 1; i <= 3; i++) {
            newans=finalans;
            factor /= 10.0;
            for (int j = 0; j <= 9; j++) {
                newans+=factor;     //<---check
                if (newans*newans==x) { // doesn't matter much even if we dont use the integer overflow case
                    System.out.println(newans);
                    return;
                } else if (newans*newans <= x) {
                    finalans = newans;
                } else {
                    break;
                }
            }
        }
        System.out.println("The answer in decimals is" + finalans);
    }
}
// 1.concept of binary search
// 2.handling the / by zero case
// 3.integer overflow case
