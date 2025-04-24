/* 
import java.util.*;

public class KokoEatingBananas {

    public static int findMax(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] arr, int h) {
        int totalH = 0;
        for (int i = 0; i < arr.length; i++) {
            totalH += (int) Math.ceil((double) arr[i] / h);
        }
        return totalH;
    }

    public static int minRate(int[] arr, int h) {
        int maxi = findMax(arr);
        for (int i = 1; i <= maxi; i++) {
            int reqTime = calculateTotalHours(arr, i);
            if (reqTime <= h) {
                return i;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of piles: ");
        int n = sc.nextInt();

        int[] arr = new int[n];  
        System.out.println("Enter bananas in each pile:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); 
        }

        System.out.print("Enter total hours: ");
        int h = sc.nextInt(); 

        int result = minRate(arr, h);  
        System.out.println("Koko should eat at least " + result + " bananas/hr.");

        sc.close();
    }
}
*/
/*
Time Complexity: O(m × n)
Space Complexity: O(1)
 */

 import java.util.*;

public class KokoEatingBananas {

    public static int findMax(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] arr, int h) {
        int totalH = 0;
        for (int i = 0; i < arr.length; i++) {
            totalH += (int) Math.ceil((double) arr[i] / h);
        }
        return totalH;
    }

    public static int minRate(int[] arr, int h) {
        
        int low = 1;
        int high = findMax(arr);

        while(low<=high){
            int mid = low + (high-low)/2;
            int totalH = calculateTotalHours(arr, mid);
            if(totalH  <= h){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of piles: ");
        int n = sc.nextInt();

        int[] arr = new int[n];  
        System.out.println("Enter bananas in each pile:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); 
        }

        System.out.println("Enter total hours: ");
        int h = sc.nextInt(); 

        int result = minRate(arr, h);  
        System.out.println("Koko should eat at least " + result + " bananas/hr.");

        sc.close();
    }
}

/*
Time Complexity: O(n log m)
Space Complexity: O(1)
 */