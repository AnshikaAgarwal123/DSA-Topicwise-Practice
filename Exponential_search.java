//Exponential search, Doubling, Galloping search
//Infinite size sorted array
public class Exponential_search {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40, 50, 70, 90, 110, 130, 160, 200};  //this is just a sample test case, the actual array is of infinite length
        int target = 40;
        if(arr[0]==target){
            System.out.println(0);
            return;
        }
        int i=1;
        while(arr[i]<=target){
            i*=2;
        }
        if(arr[i]>target){
            int start=i/2;
            int end=i;
            while(start<=end){
                int mid= start+(end-start)/2;
                if(arr[mid]==target){
                    System.out.println(mid);
                    return;
                }
                else if(arr[mid]>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        System.out.println(-1);
    }
}
