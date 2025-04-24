/*
import java.util.*;

public class RotatedArraySearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; 
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

        System.out.println("Enter the target value to search for: ");
        int target = sc.nextInt();

        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Target not found.");
        } else {
            System.out.println("Target found at index: " + result);
        }

        sc.close();
    }
}
*/
/*
Time Complexity: O(n)
Space Complexity: O(1)
 */

 import java.util.*;

 public class RotatedArraySearch2 {
 
     public static int binarySearch(int[] arr, int target) {
         int low = 0, high = arr.length - 1;
 
         while (low <= high) {
             int mid = low + (high - low) / 2;
 
             if (arr[mid] == target) {
                 return mid;
             }
 
             if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                 low++;
                 high--;
             } else if (arr[low] <= arr[mid]) {
                 if (arr[low] <= target && target < arr[mid]) {
                     high = mid - 1;
                 } else {
                     low = mid + 1;
                 }
             } else {
                 if (arr[mid] < target && target <= arr[high]) {
                     low = mid + 1;
                 } else {
                     high = mid - 1;
                 }
             }
         }
         return -1;
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
 
         System.out.println("Enter the target value to search for: ");
         int target = sc.nextInt();
 
         int result = binarySearch(arr, target);
 
         if (result == -1) {
             System.out.println("Target not found.");
         } else {
             System.out.println("Target found at index: " + result);
         }
 
         sc.close();
     }
 }
 
 /*
 Time Complexity: O(log n) in best/average case, O(n) in worst case (when duplicates present)
 Space Complexity: O(1)
 */
 