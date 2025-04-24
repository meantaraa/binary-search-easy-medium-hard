/*
import java.util.*;

public class FindMedian {

    public static int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] flat = new int[n * m];

        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                flat[index++] = num;
            }
        }

        Arrays.sort(flat);
        return flat[(m * n) / 2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int n = scanner.nextInt();

        System.out.println("Enter number of columns: ");
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        System.out.println("Enter the elements row-wise (each row should be sorted):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int median = findMedian(matrix);
        System.out.println("The median is: " + median);
        
        scanner.close();
    }
}
*/
/*
Time Complexity: O(n log n*n*m)
Space Complexity: O(n*m)
*/
import java.util.*;

public class FindMedian {

    public static int countSmallerOrEqual(int[] row, int target){
        int low = 0;
        int high = row.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if (row[mid] <= target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }

    public static int findMedian(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0; i<m; i++){
            low= Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n-1]);
        }

        while(low <= high){
            int mid = (low+high)/2;
            int count = 0;

            for(int i=0; i<m; i++){
                count += countSmallerOrEqual(matrix[i], mid);
            }

            if (count < (m * n) / 2 + 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    
        return low;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int n = scanner.nextInt();

        System.out.println("Enter number of columns: ");
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        System.out.println("Enter the elements row-wise (each row should be sorted):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int median = findMedian(matrix);
        System.out.println("The median is: " + median);
        
        scanner.close();
    }
}
/*
Time Complexity: O(n log n*n*m)
Space Complexity: O(n*m)
*/
