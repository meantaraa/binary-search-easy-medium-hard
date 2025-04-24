/*
import java.util.*;

public class SearchInSorted2D {

    public static boolean searchMatrix(int[][] mat, int target){
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int n = sc.nextInt();

        System.out.println("Enter the number of columns: ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("enter the matrix elements: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
       
        System.out.println("Enter the target elements: ");
        int target = sc.nextInt();

        boolean found = searchMatrix(mat, target);

        if(found) {
            System.out.println("Target found in the matrix.");
        }else{
            System.out.println("Target not found in the matrix.");
        }

        sc.close();
    }
}
*/
/*
 Time Complexity: O(m*n)
 Space Complexity: O(1)
*/
import java.util.*;

public class SearchInSorted2D {

    public static boolean searchMatrix(int[][] mat, int target){
       
        if(mat == null || mat.length == 0 || mat[0].length == 0){
            return false;
        }

        int n = mat.length;
        int m = mat[0].length;

        int left = 0;
        int right = n*m - 1;

        while(left <= right){
            int mid = (left+right)/2;
            int row = mid/m;
            int col = mid%m;
            int midValue = mat[row][col];

            if(midValue == target){
                return true;
            }else if(midValue < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;
    }
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int n = sc.nextInt();

        System.out.println("Enter the number of columns: ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("enter the matrix elements: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
       
        System.out.println("Enter the target elements: ");
        int target = sc.nextInt();

        boolean found = searchMatrix(mat, target);

        if(found) {
            System.out.println("Target found in the matrix.");
        }else{
            System.out.println("Target not found in the matrix.");
        }

        sc.close();
    }
}
/*
 Time Complexity: O(n*logm)
 Space Complexity: O(1)
*/