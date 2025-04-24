/* 
import java.util.*;

public class NthRootOfN {

    public static int nthRootOfN(int N, int M){

        for(int i=1; i<= M; i++) {
            long power = (int) Math.pow(i, N);
            if(power == M) return i;
            if(power  > M) break;
        }

        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N (root): ");
        int N = sc.nextInt();
        System.out.println("Enter M (number): ");
        int M = sc.nextInt();

        int result = nthRootOfN(N, M);
        System.out.println("Result: " + result);
        sc.close();
    }
}
*/

import java.util.*;

public class NthRootOfN {

    public static int nthRootOfN(int N, int M){

        int low = 1;
        int high = M;

        while(low<=high){
            int mid = low + (high-low)/2;
            int power = (int)Math.pow(mid, N);

            if(power == M) return mid;
            if(power < M) low = mid+1;
            else high = mid-1;
        }

        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N (root): ");
        int N = sc.nextInt();
        System.out.println("Enter M (number): ");
        int M = sc.nextInt();

        int result = nthRootOfN(N, M);
        System.out.println("Result: " + result);
        sc.close();
    }
}
