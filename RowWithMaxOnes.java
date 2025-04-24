/* 
import java.util.Scanner;

public class RowWithMaxOnes {
    public static int rowWithMaxOnes(int[][] mat) {
        int maxOnes = 0;
        int rowIndex = -1;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxOnes) {
                maxOnes = count;
                rowIndex = i;
            }
        }

        return maxOnes > 0 ? rowIndex : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the matrix (only 0s and 1s, sorted rows):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int result = rowWithMaxOnes(mat);
        if (result == -1) {
            System.out.println("No row has at least one 1.");
        } else {
            System.out.println("Row with max 1s: " + result);
        }

        sc.close();
    }
}
*/

/*
 Time Complexity: O(n*m)
 Space Complexity: O(n*m)
*/

import java.util.*;

public class RowWithMaxOnes {

    public static int rowWithMaxOnes(int[][] mat) {
        int maxOnes = 0;
        int rowIdx = -1;

        for(int i=0; i<mat.length; i++){
            int firstOneIdx = firstOneIndex(mat[i]);
            int countOnes = mat[i].length - firstOneIdx;

            if (countOnes > maxOnes){
                maxOnes = countOnes;
                rowIdx = i;
            }
        }

        if (maxOnes > 0) {
            return rowIdx;
        }else{
            return -1;
        }
    }

    public static int firstOneIndex(int[] row){
        int n = row.length;
        int low = 0;
        int high = n-1;
        int result = n;

        while(low<=high){
            int mid = (low+high)/2;
            if(row[mid] == 1){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the matrix (only 0s and 1s, sorted rows):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int result = rowWithMaxOnes(mat);
        if (result == -1) {
            System.out.println("No row has at least one 1.");
        } else {
            System.out.println("Row with max 1s: " + result);
        }

        sc.close();
    }
}
/*
 Time Complexity: O(n*logm)
 Space Complexity: O(1)
*/

