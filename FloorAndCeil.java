/*
import java.util.*;

public class FloorAndCeil {
    public static int findFloor(int[] arr, int n, int x){
        int floor = -1;
        for(int i = 0; i < n; i++){
            if(arr[i] <= x){
                floor = arr[i];
            } else {
                break;
            }
        }
        return floor;
    }

    public static int findCeil(int[] arr, int n, int x){
        for(int i = 0; i < n; i++){
            if(arr[i] >= x){
                return arr[i];
            }
        }
        return -1;
    }

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

import java.util.*;

public class FloorAndCeil {

    public static int findFloor(int[] arr, int n, int x){
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] <= x){
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findCeil(int[] arr, int n, int x){
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] >= x){
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int[] getFloorAndCeil(int[] arr, int n, int x){
        int f = findFloor(arr, n, x);
        int c = findCeil(arr, n, x);
        return new int[]{f, c};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements in sorted order:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target value:");
        int x = sc.nextInt();

        sc.close();

        int[] res = getFloorAndCeil(arr, n, x);
        System.out.println("Floor: " + res[0]);
        System.out.println("Ceil: " + res[1]);
    }
}

/*
  Time Complexity: O(log n)
  Space Complexity: O(1)
 */