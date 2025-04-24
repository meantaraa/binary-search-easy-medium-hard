/* import java.util.*;

public class CapacityToShip {

    public static int findDays(int[] arr, int c) {
        int n = arr.length;
        int load = 0;
        int day = 1;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > c) {
                return Integer.MAX_VALUE;
            }
            if (load + arr[i] > c) {
                day++;
                load = arr[i];
            } else {
                load += arr[i];
            }
        }

        return day;
    }

    public static int leastCapacity(int[] arr, int d) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        for (int i = max; i <= sum; i++) {
            if (findDays(arr, i) <= d) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of packages: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter package weights:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter number of days: ");
        int d = sc.nextInt();

        int result = leastCapacity(arr, d);
        System.out.println("Least ship capacity to ship in " + d + " days: " + result);
        
        sc.close();
    }
}
*/

/*
Time Complexity: O((sum-max)+1)*n)
Space Complexity = 1
 */

 import java.util.*;

public class CapacityToShip {

    public static int findDays(int[] arr, int c) {
        int n = arr.length;
        int load = 0;
        int day = 1;
        
        for (int i = 0; i < n; i++) {
            if (load + arr[i] > c) {
                day++;
                load = arr[i];
            } else {
                load += arr[i];
            }
        }
        return day;
    }

    public static int leastCapacity(int[] arr, int d) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<n; i++){
            max = Math.max(arr[i], max);
            sum += arr[i];
        }

       int low = max;
       int high = sum;
       
       while(low<=high){
        int mid = low + (high-low)/2;
        if(findDays(arr, mid) <= d){
            high = mid-1;
        }else{
            low = mid+1;
        }
      }
        return low;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of packages: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter package weights:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter number of days: ");
        int d = sc.nextInt();

        int result = leastCapacity(arr, d);
        System.out.println("Least ship capacity to ship in " + d + " days: " + result);
        
        sc.close();
    }
}

/*
Time Complexity: O(log(sum-max)+1)*n)
Space Complexity = 1
 */