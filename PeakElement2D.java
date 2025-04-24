/*
import java.util.*;

public class PeakElement2D {

    public int[] peakElement2D(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = mat[i][j];
                int up = (i > 0) ? mat[i - 1][j] : -1;
                int down = (i < n - 1) ? mat[i + 1][j] : -1;
                int left = (j > 0) ? mat[i][j - 1] : -1;
                int right = (j < m - 1) ? mat[i][j + 1] : -1;

                if (val > up && val > down && val > left && val > right) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        PeakElement2D obj = new PeakElement2D();
        int[] result = obj.peakElement2D(mat);

        if (result[0] != -1) {
            System.out.println("Peak element found at: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No peak element found.");
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

public class PeakElement2D {

    public int[] peakElement2D(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int left = 0;
        int right = n-1;

        while(left <= right){
            int mid = (left+right)/2;
            int maxRow = 0;

            for(int i=0; i<m; i++){
                if(mat[i][mid] > mat[maxRow][mid]);{
                maxRow = i;
                
                }
            }

            int leftVal = (mid > 0) ? mat[maxRow][mid-1]: -1;
            int rightVal = (mid < n-1) ? mat[maxRow][mid+1]: -1;

            if (mat[maxRow][mid] > leftVal && mat[maxRow][mid] > rightVal) {
                return new int[]{maxRow, mid};
            } else if (rightVal > mat[maxRow][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    
        return new int[]{-1, -1}; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        PeakElement2D obj = new PeakElement2D();
        int[] result = obj.peakElement2D(mat);

        if (result[0] != -1) {
            System.out.println("Peak element found at: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No peak element found.");
        }

        sc.close();
    }
}