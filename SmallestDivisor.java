/*
import java.util.*;

public class SmallestDivisor {

    public static int smallestDivisor(int[] arr, int limit){
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int d = 1; d <= max; d++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double) arr[i] / (double) d);
            }
            if (sum <= limit) {
                return d;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the limit: ");
        int limit = sc.nextInt();

        int result = smallestDivisor(arr, limit);
        System.out.println("The smallest divisor is: " + result);

        sc.close();
    }
}
*/
/*
 Time Complexity: O(n*m)
 Space Complexity: O(1)
*/

import java.util.*;

public class SmallestDivisor {

    public static int sumByD(int[] arr, int div){
        int n = arr.length;
        int sum =0;
        for(int i=0; i<n; i++){
            sum += Math.ceil((double)(arr[i])/ (double)(div));
        }
        return sum;
    }

    public static int smallestDivisor(int[] arr, int limit){

        int n = arr.length;
        if(n > limit) return -1;

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
        }

        int low = 1; 
        int high = max;

        while(low <= high){
            int mid = (low+high)/2;
            if(sumByD(arr, mid) <= limit){
                high = mid - 1;
            }else{
                low =  mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the limit: ");
        int limit = sc.nextInt();

        int result = smallestDivisor(arr, limit);
        System.out.println("The smallest divisor is: " + result);

        sc.close();
    }
}
/*
 Time Complexity: O(n log m)
 Space Complexity: O(1)
*/