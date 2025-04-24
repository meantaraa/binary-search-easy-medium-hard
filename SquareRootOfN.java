/* import java.util.*;

public class SquareRootOfN {

    public static int squareRootOfN(int n) {
        int ans = 0;

        for (long i = 1; i <= n; i++) {
            long val = i * i;
            if (val <= (long) n) {
                ans = (int) i;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        int result = squareRootOfN(n);
        System.out.println("The floor of the square root of " + n + " is: " + result);
        
        sc.close(); 
    }
}
*/

/*
 Time Complexity: O(n)
 Space Complexity: O(1)
*/

import java.util.*;

public class SquareRootOfN{

    public static int squareRootOfN(int n){

        int ans = 0;
        int low = 0;
        int high = n;

        while(low <= high){

            int mid = low + (high-low)/2;
            int square = (int) mid*mid;

            if(square == n){
                return mid;
            }else if(square < n){
                ans = mid; 
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        int result = squareRootOfN(n);
        System.out.println("The floor of the square root of " + n + " is: " + result);
        
        sc.close(); 
    }
}

/*
 Time Complexity: O(log n)
 Space Complexity: O(1)
*/
