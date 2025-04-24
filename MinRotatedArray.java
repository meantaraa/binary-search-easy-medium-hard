/*
import java.util.*;

public class RotatedArraySearch {
    public static int linearSearch(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the rotated sorted array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findMin(arr);

        System.out.println("The minimum element is: " + result);

        sc.close();
    }
}
*/
/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MinRotatedArray {

    public static int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[high]) {
                high = mid;
            } else if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high--; // handles duplicates
            }
        }

        return arr[low];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the rotated sorted array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findMin(arr);

        System.out.println("The minimum element is: " + result);

        sc.close();
    }
}

/*
Time Complexity: O(log n) in best/average case, O(n) in worst case (with duplicates)
Space Complexity: O(1)
*/

