/*
import java.util.*;

public class PeakElement {
    
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();

        for (int i = 0; i < n; i++) {
            if ((i == 0 || arr.get(i - 1) < arr.get(i)) && (i == n - 1 || arr.get(i) > arr.get(i + 1))) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        int peakIndex = findPeakElement(arr);

        if (peakIndex != -1) {
            System.out.println("The peak element is at index: " + peakIndex);
        } else {
            System.out.println("No peak element found.");
        }

        scanner.close();
    }
}
*/

/*
 Time Complexity: O(n)
 Space Complexity: O(n)
*/

import java.util.*;

public class PeakElement {
    
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();
        
        if (n==1) return 0;
        if(arr.get(0) > arr.get(1)) return 0;
        if(arr.get(n-1) > arr.get(n-2)) return n-1;

        int low = 1;
        int high = n-2;

        while(low <= high) {
            int mid = (low+high)/2;

            if(arr.get(mid-1) < arr.get(mid) && arr.get(mid) > arr.get(mid+1)){
                return mid;
            }

            if(arr.get(mid) > arr.get(mid-1)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        int peakIndex = findPeakElement(arr);

        if (peakIndex != -1) {
            System.out.println("The peak element is at index: " + peakIndex);
        } else {
            System.out.println("No peak element found.");
        }

        scanner.close();
    }
}
/*
 Time Complexity: O(logn)
 Space Complexity: O(n)
*/
