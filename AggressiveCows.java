/* 
import java.util.*;

public class AggressiveCows {

    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int countCows = 1;
        int lastPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= dist) {
                countCows++;
                lastPlaced = stalls[i];
            }
            if (countCows >= cows) return true;
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int maxDist = stalls[stalls.length - 1] - stalls[0];

        for (int dist = 1; dist <= maxDist; dist++) {
            if (!canWePlace(stalls, dist, cows)) {
                return dist - 1;
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of stalls: ");
        int n = sc.nextInt();
        int[] stalls = new int[n];

        System.out.println("Enter the positions of the stalls:");
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        System.out.println("Enter the number of cows to place: ");
        int cows = sc.nextInt();

        int result = aggressiveCows(stalls, cows);
        System.out.println("The largest minimum distance between any two cows is: " + result);
    }
}
*/

/*
 Time Complexity: O(nlogn + O(n*d))
 Space Complexity: O(1)
 */

 import java.util.*;

 public class AggressiveCows {
 
     public static boolean canWePlace(int[] stalls, int dist, int cows) {
         int countCows = 1;
         int lastPlaced = stalls[0];
 
         for (int i = 1; i < stalls.length; i++) {
             if (stalls[i] - lastPlaced >= dist) {
                 countCows++;
                 lastPlaced = stalls[i];
             }
             if (countCows >= cows) return true;
         }
         return false;
     }
 
     public static int aggressiveCows(int[] stalls, int k) {

         int n = stalls.length;
         Arrays.sort(stalls);

         int low = 1;
         int high = stalls[n-1] - stalls[0];
         int ans = 0;

         while(low<=high) {
            int mid = (low+high)/2;
            if(canWePlace(stalls, mid, k)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
         }
         
         return ans;
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         System.out.println("Enter the number of stalls: ");
         int n = sc.nextInt();
         int[] stalls = new int[n];
 
         System.out.println("Enter the positions of the stalls:");
         for (int i = 0; i < n; i++) {
             stalls[i] = sc.nextInt();
         }
 
         System.out.println("Enter the number of cows to place: ");
         int cows = sc.nextInt();
 
         int result = aggressiveCows(stalls, cows);
         System.out.println("The largest minimum distance between any two cows is: " + result);
     }
 }

/*
 Time Complexity: O(nlogn + O(n*log d))
 Space Complexity: O(1)
 */