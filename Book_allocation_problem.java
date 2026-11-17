/* Problem Name: Allocate Minimum Pages (Book Allocation Problem)
 * Example 1:
 * Input: arr[] = [12, 34, 67, 90], k = 2
 * Output: 113
 * Explanation: Allocation can be done in following ways:
 *   => [12] and [34, 67, 90] Maximum Pages = 191
 *   => [12, 34] and [67, 90] Maximum Pages = 157
 *   => [12, 34, 67] and [90] Maximum Pages = 113.
 * The third combination has the minimum pages assigned to a student which is 113.
 * 
 * Example 2:
 * Input: arr[] = [15, 17, 20], k = 5
 * Output: -1
 * Explanation: Since there are more students than total books, it's impossible to allocate 
 * a book to each student.
 */
class Book_allocation_problem {
    public static boolean isvalid(int[] arr, int k, long maxPages){
        long studentno=1;
        long pages=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>maxPages){    //Make sure that the pages in one book are not greater than the max pages 
                return false;
            }
            else if(pages+arr[i]<=maxPages){
                pages+=arr[i];
            }
            else{
                pages=arr[i];
                studentno++;
            }
        }
        
        if(studentno>k){
            return false;
        }
        else{
            return true;
        }
    }
    
    public int findPages(int[] arr, int k) {
        int n= arr.length;
        if(n<k){
            return -1;
        }
        long start=0;
        long sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        long end=sum;
        while(start<=end){
            long mid= start+(end-start)/2;
            if (isvalid(arr, k, mid)){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        int ans=(int)start;
        return ans;
    }

    // --- Add the main method here ---
    public static void main(String[] args) {
        Book_allocation_problem solver = new Book_allocation_problem();
        
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        
        int result = solver.findPages(arr, k);
        System.out.println("Minimum number of pages: " + result); // Expected Output: 113
    }
}
//To be on safer side for Integer overflow try to use long for it
