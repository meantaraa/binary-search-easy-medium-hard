/*
 import java.util.*;

public class PaintersPartition {

    public static int countPainters(ArrayList<Integer> boards, int maxLen) {
        int n = boards.size();
        int painters = 1;
        int currLen = 0;

        for (int i = 0; i < n; i++) {
            if (currLen + boards.get(i) <= maxLen) {
                currLen += boards.get(i);
            } else {
                painters++;
                currLen = boards.get(i);
            }
        }

        return painters;
    }

    public static int findMinTime(ArrayList<Integer> boards, int n, int k) {
        if (k > n) return -1;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, boards.get(i));
            sum += boards.get(i);
        }

        int low = max;
        int high = sum;

        for (int j = low; j <= high; j++) {
            if (countPainters(boards, j) == k) {
                return j;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of boards: ");
        int n = sc.nextInt();

        ArrayList<Integer> boards = new ArrayList<>();
        System.out.println("Enter the length of each board:");
        for (int i = 0; i < n; i++) {
            boards.add(sc.nextInt());
        }

        System.out.println("Enter the number of painters: ");
        int k = sc.nextInt();

        int ans = findMinTime(boards, n, k);
        System.out.println("The minimum time to paint all boards is: " + ans);
    }
}

 */

/*
 Time Complexity: O((high-low+1)*n)
 Space Complexity: O(1)
 */

 import java.util.*;

 public class PaintersPartition {
 
     public static int countPainters(ArrayList<Integer> boards, int maxLen) {
         int n = boards.size();
         int painters = 1;
         int currLen = 0;
 
         for (int i = 0; i < n; i++) {
             if (currLen + boards.get(i) <= maxLen) {
                 currLen += boards.get(i);
             } else {
                 painters++;
                 currLen = boards.get(i);
             }
         }
 
         return painters;
     }
 
     public static int findMinTime(ArrayList<Integer> boards, int n, int k) {
         if (k > n) return -1;
 
         int max = Integer.MIN_VALUE;
         int sum = 0;
 
         for (int i = 0; i < n; i++) {
             max = Math.max(max, boards.get(i));
             sum += boards.get(i);
         }
 
         int low = max;
         int high = sum;
         int ans = 0;
 
         while (low <= high) {
             int mid = low + (high - low) / 2;
 
             if (countPainters(boards, mid) == k) {
                 ans = mid;
                 low = mid + 1;
             } else {
                 high = mid - 1;
             }
         }
         return low;
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         System.out.println("Enter the number of boards: ");
         int n = sc.nextInt();
 
         ArrayList<Integer> boards = new ArrayList<>();
         System.out.println("Enter the length of each board:");
         for (int i = 0; i < n; i++) {
             boards.add(sc.nextInt());
         }
 
         System.out.println("Enter the number of painters: ");
         int k = sc.nextInt();
 
         int ans = findMinTime(boards, n, k);
         System.out.println("The minimum time to paint all boards is: " + ans);
     }
 }
 
 /*
  Time Complexity: O(log(high-low+1)*n)
  Space Complexity: O(1)
 */
 