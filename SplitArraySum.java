/*
import java.util.*;

public class SplitArraySum {

    public static int countPartitions(ArrayList<Integer> arr, int maxSum) {
        int n = arr.size();
        int partitions = 1;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            if (currentSum + arr.get(i) <= maxSum) {
                currentSum += arr.get(i);
            } else {
                partitions++;
                currentSum = arr.get(i);
            }
        }

        return partitions;
    }

    public static int findMinimizedLargestSum(ArrayList<Integer> arr, int n, int k) {
        if (k > n) return -1;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr.get(i));
            sum += arr.get(i);
        }

        int result = 0;
        
        for (int i = max; i <= sum; i++) {
            if (countPartitions(arr, i) <= k) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println("Enter the number of subarrays: ");
        int k = sc.nextInt();

        int ans = findMinimizedLargestSum(arr, n, k);
        System.out.println("The minimized largest sum after splitting the array into " + k + " subarrays is: " + ans);
    }
}
*/

 /*
 Time Complexity: O((sum - max) * n)
 Space Complexity: O(1)
 */

  import java.util.*;

  public class SplitArraySum {
  
      public static boolean isPossible(ArrayList<Integer> arr, int n, int k, int maxSum) {
          int currentSum = 0;
          int requiredPartitions = 1;
  
          for (int i = 0; i < n; i++) {
              if (currentSum + arr.get(i) > maxSum) {
                  requiredPartitions++;
                  currentSum = arr.get(i);
                  if (requiredPartitions > k) {
                      return false;
                  }
              } else {
                  currentSum += arr.get(i);
              }
          }
  
          return true;
      }
  
      public static int findMinLargestSum(ArrayList<Integer> arr, int n, int k) {
          int low = Collections.max(arr);
          int high = arr.stream().mapToInt(Integer::intValue).sum();
          int result = high;
  
          while (low <= high) {
              int mid = low + (high - low) / 2;
  
              if (isPossible(arr, n, k, mid)) {
                  result = mid;
                  high = mid - 1;
              } else {
                  low = mid + 1;
              }
          }
  
          return result;
      }
  
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
  
          System.out.println("Enter the size of the array: ");
          int n = sc.nextInt();
  
          ArrayList<Integer> arr = new ArrayList<>();
          System.out.println("Enter the elements of the array:");
          for (int i = 0; i < n; i++) {
              arr.add(sc.nextInt());
          }
  
          System.out.println("Enter the number of subarrays (K): ");
          int k = sc.nextInt();
  
          int result = findMinLargestSum(arr, n, k);
          System.out.println("The minimized largest sum of the split is: " + result);
      }
  }
  
  /*
   Time Complexity: O(log(sum of elements) * N)
   Space Complexity: O(1)
  */
  