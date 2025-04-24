/* 
import java.util.*;

public class SearchInsertPos {

    public static int searchInsertPos(int[] arr, int n, int k){

        for(int i = 0; i < n; i++){
            if(arr[i] >= k){
                return i;
            }
        }

        return n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // Ensures correct insert position

        System.out.println("Enter the value of the target: ");
        int k = sc.nextInt();

        int result = searchInsertPos(arr, n, k);

        System.out.println("The target should be placed at index: " + result);
    }
}
*/

/*
 Time Complexity: O(n)
 Space Complexity: O(1)
*/

import java.util.*;

public class SearchInsertPos {

    public static int searchInsertPos(int[] arr, int n, int k){

        int low = 0;
        int high = n - 1;
        int ans = n;

        while(low <= high){
            int mid = low+(high-low)/2;

            if(arr[mid] >= k){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // Sorting is essential for binary search correctness

        System.out.println("Enter the value of the target: ");
        int k = sc.nextInt();

        int result = searchInsertPos(arr, n, k);

        System.out.println("The target should be placed at index: " + result);
    }
}

/*
 Time Complexity: O(log n)
 Space Complexity: O(1)
*/
