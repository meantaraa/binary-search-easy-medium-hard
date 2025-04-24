/*
 import java.util.*;

public class BookAllocation {

    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int students = 1;
        int pagesCount = 0;

        for (int i = 0; i < n; i++) {
            if (pagesCount + arr.get(i) <= pages) {
                pagesCount += arr.get(i);
            } else {
                students++;
                pagesCount = arr.get(i);
            }
        }

        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr.get(i));
            sum += arr.get(i);
        }

        int low = max;
        int high = sum;

        for (int j = low; j <= high; j++) {
            if (countStudents(arr, j) == m) {
                return j;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of books: ");
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter the number of pages in each book:");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println("Enter the number of students: ");
        int m = sc.nextInt();

        int ans = findPages(arr, n, m);
        System.out.println("The minimum number of pages allocated to a student is: " + ans);
    }
}

 */

 /*
 Time Complexity: O((high-low+1)*n)
 Space Complexity: O(1)
  */
  import java.util.*;

  public class BookAllocation {
  
      public static int countStudents(ArrayList<Integer> arr, int pages) {
          int n = arr.size();
          int students = 1;
          int pagesCount = 0;
  
          for (int i = 0; i < n; i++) {
              if (pagesCount + arr.get(i) <= pages) {
                  pagesCount += arr.get(i);
              } else {
                  students++;
                  pagesCount = arr.get(i);
              }
          }
  
          return students;
      }
  
      public static int findPages(ArrayList<Integer> arr, int n, int m) {
          if (m > n) return -1;
  
          int max = Integer.MIN_VALUE;
          int sum = 0;
  
          for (int i = 0; i < n; i++) {
              max = Math.max(max, arr.get(i));
              sum += arr.get(i);
          }
  
          int low = max;
          int high = sum;
          int ans = 0;
  
          while(low <= high){
            int mid = low + (high-low)/2;

            if(countStudents(arr, mid) == m){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
          }
          return low;
      }
  
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
  
          System.out.println("Enter the number of books: ");
          int n = sc.nextInt();
  
          ArrayList<Integer> arr = new ArrayList<>();
          System.out.println("Enter the number of pages in each book:");
          for (int i = 0; i < n; i++) {
              arr.add(sc.nextInt());
          }
  
          System.out.println("Enter the number of students: ");
          int m = sc.nextInt();
  
          int ans = findPages(arr, n, m);
          System.out.println("The minimum number of pages allocated to a student is: " + ans);
      }
  }

/*
 Time Complexity: O(log(high-low+1)*n)
 Space Complexity: O(1)
*/