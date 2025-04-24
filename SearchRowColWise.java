/*
import java.util.*;

public class SearchRowColWise {

    public static boolean searchMatrix(int[][] matrix, int target){
        int n = matrix.length; 
        int m = matrix[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows (N): ");
        int n = sc.nextInt();

        System.out.println("Enter number of columns (M): ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the target element to search: ");
        int target = sc.nextInt();

        if (searchMatrix(mat, target)) {
            System.out.println("Target found in the matrix.");
        } else {
            System.out.println("Target not found in the matrix.");
        }

        sc.close();
    }
}
*/
/*
 Time Complexity: O(n*m)
 Space Complexity: O(1)
*/
import java.util.*;

public class SearchRowColWise {

    public static boolean searchMatrix(int[][] matrix, int target){
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int row = 0;
        int col = m-1;

        while(row<n && col>=0){
            if(matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows (N): ");
        int n = sc.nextInt();

        System.out.println("Enter number of columns (M): ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the target element to search: ");
        int target = sc.nextInt();

        if (searchMatrix(mat, target)) {
            System.out.println("Target found in the matrix.");
        } else {
            System.out.println("Target not found in the matrix.");
        }

        sc.close();
    }
}
/*
 Time Complexity: O(n+m)
 Space Complexity: O(1)
*/