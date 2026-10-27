// 704. Binary Search
//Example 1:
// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4.
import java.util.*;
public class Binary_search {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int array[]= new int[n];
        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        int target= sc.nextInt();
        int start=0; 
        int end=n-1;
        while(start<=end){
            int mid= start+ ((end-start)/2);
            if(array[mid]==target){
                System.out.println(mid);
                return;
            }
            else if(array[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        System.out.println(-1);
    }
}
