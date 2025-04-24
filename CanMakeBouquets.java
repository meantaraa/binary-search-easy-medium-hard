/*
import java.util.*;

public class CanMakeBouquets {
    public static boolean possible(int[] arr, int day, int m, int k){
        int n = arr.length;
        int cnt = 0;
        int noOfB = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= day){
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    public static int roseGarden(int[] arr, int k, int n, int m) {
        if (m * k > n) return -1;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        for(int i = mini; i <= maxi; i++){
            if(possible(arr, i, m, k)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of flowers: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the bloom days of each flower:");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number of adjacent flowers needed for one bouquet (k): ");
        int k = sc.nextInt();

        System.out.println("Enter the number of bouquets needed (m): ");
        int m = sc.nextInt();

        int ans = roseGarden(arr, k, n, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
}

 */

/*
Time Complexity: O(n*m)
Space Complexity: O(1)
*/

import java.util.*;

public class CanMakeBouquets {
    public static boolean possible(int[] arr, int day, int m, int k){
        int n = arr.length;
        int cnt = 0;
        int noOfB = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= day){
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    public static int roseGarden(int[] arr, int k, int n, int m) {
        if (m * k > n) return -1;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        
        int answer = -1;
        int low = mini;
        int high = maxi;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(arr, mid, m, k)){
                answer = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of flowers: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the bloom days of each flower:");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number of adjacent flowers needed for one bouquet (k): ");
        int k = sc.nextInt();

        System.out.println("Enter the number of bouquets needed (m): ");
        int m = sc.nextInt();

        int ans = roseGarden(arr, k, n, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
}

/*
Time Complexity: O(n log m)
Space Complexity: O(1)
*/
