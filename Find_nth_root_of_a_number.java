//185. Find Nth root of a number
// Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M. If the Nth root is not an integer, return -1.
//Example 1:
// Input: N = 3, M = 27
// Output: 3
// Explanation: The cube root of 27 is equal to 3.
//Example 2:
// Input: N = 4, M = 69
// Output:-1
// Explanation: The 4th root of 69 does not exist. So, the answer is -1.
import java.util.Scanner;
class Find_nth_root_of_a_number {
    public int NthRoot(int N, int M) {
        long start=0;
        long end=M;
        if(M==0){
            return -1;
        }
        while(start<=end){
            long multiple=1;
            long mid= start+(end-start)/2;
            for(long i=0; i<N; i++){
                multiple*=mid;
                if(multiple>M){     //the core idea:- It breaks the loop where the value becomes very large preventing integer overflow.
                    break;
                }
            }

            if(multiple==M){
                return (int)mid;
            }
            else if(multiple>M){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        
        System.out.print("Enter M: ");
        int M = scanner.nextInt();
        
        Find_nth_root_of_a_number sol = new Find_nth_root_of_a_number();
        int result = sol.NthRoot(N, M);
        
        System.out.println("The Nth Root is: " + result);
        
        scanner.close();
    }
}
