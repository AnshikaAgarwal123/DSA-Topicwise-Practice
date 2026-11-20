import java.util.*;
public class Eko_spoj {
    static boolean isValidAns(int trees[], long m, int maxheight){
        long wood=0;
        for(int i=0; i<trees.length; i++){
            if((trees[i]-maxheight)>0)
            wood+= trees[i]-maxheight;
        }
        if(wood>=m){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        long m= sc.nextInt();
        int trees[]= new int[n];
        for(int i=0; i<n; i++){
            trees[i]= sc.nextInt();
        }
        
        int start=0;
        int end= 0;
        int ans=0;
        for(int i=0; i<n; i++){
            end= Math.max(trees[i], end);
        }
        while(start<=end){
            int mid= start+(end-start)/2;
            if(isValidAns(trees, m, mid)){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        System.out.println(ans);
    }
}
