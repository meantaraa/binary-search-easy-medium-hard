/*
import java.util.Scanner;

public class SingleElement {
    public static int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = singleNonDuplicate(nums);
        System.out.println(result);
    }
}
*/
/*
 Time Complexity: O(n)
 Space Complexity: O(1)
*/

import java.util.*;

public class SingleElement {
    public static int singleElement(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }
        if(arr[0] != arr[1]){
            return arr[0];
        }
        if(arr[n-1] != arr[n-2]){
            return arr[n-1];
        }

        int low = 1;
        int high = n-2;
        
        while(low <= high) {
            int mid = (low+high)/2;

            if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
                return arr[mid];
            }

            if((mid%2 == 1 && arr[mid] == arr [mid-1]) || (mid%2 == 0 && arr[mid] == arr[mid+1])){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of elements in the sorted array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the sorted array elements (all pairs except one element):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = singleElement(arr);
        System.out.println("The single element is: " + result);
    }
}



