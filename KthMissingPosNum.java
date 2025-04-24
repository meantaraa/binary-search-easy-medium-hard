/*
import java.util.*;

public class KthMissingPosNum {

    public static int missing(int[] arr, int n, int k){
        for(int i=0; i<n; i++){
            if(arr[i] <= k){
                k++;
            } else break;
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter sorted array elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter value of k: ");
        int k = sc.nextInt();

        System.out.println("Kth missing positive number is: " + missing(arr, n, k));
    }
}
*/
/*
 Time Complexity: O(n)
 Space Complexity: O(1)
*/


import java.util.*;

public class KthMissingPosNum {

    public static int missing(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missingCount = arr[mid] - (mid + 1);

            if (missingCount < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + k;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter sorted array elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter value of k: ");
        int k = sc.nextInt();

        System.out.println("Kth missing positive number is: " + missing(arr, k));
    }
}
/*
 Time Complexity: O(log n)
 Space Complexity: O(1)
*/

