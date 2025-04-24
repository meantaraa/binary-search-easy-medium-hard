/*
import java.util.*;

public class BinarySearch {

    public static int binarySearch(int[] arr, int n, int k){

        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid] == k){
                return mid;
            }else if(k > arr[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println("Enter the value of the target: ");
        int k = sc.nextInt();

        int result = binarySearch(arr, n, k);

        if(result==-1){
            System.out.println("The target is not present.");
        }else{
        System.out.println("The element is present at index: " + result);
        }
    }
}
*/
/*
Time Complexity: O(log n)
  Space Complexity: O(1)
 */

import java.util.*;

public class BinarySearch {

    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1; 

        int mid = low+(high-low)/2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        return binarySearch(nums, low, mid - 1, target);
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println("Enter the value of the target: ");
        int k = sc.nextInt();

        int result = search(arr, k);

        if(result==-1){
            System.out.println("The target is not present.");
        }else{
        System.out.println("The element is present at index: " + result);
        }
    }
}

/*
  Time Complexity: O(log n)
  Space Complexity: O(1)
 */