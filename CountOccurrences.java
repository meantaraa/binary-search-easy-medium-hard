import java.util.*;

public class CountOccurrences {

    public static int findFirst(int[] arr, int x) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static int findLast(int[] arr, int x) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid;
                low = mid + 1; 
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static int countOccurrences(int[] arr, int x) {
        int first = findFirst(arr, x);
        int last = findLast(arr, x);

        if (first == -1 || last == -1) return 0;
        return last - first + 1;
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

        System.out.println("Enter the value to count:");
        int x = sc.nextInt();

        int count = countOccurrences(arr, x);
        System.out.println("Count of " + x + ": " + count);

        sc.close();
    }
}

/*
Time Complexity: O(log n)
Space Complexity: O(1)
*/
