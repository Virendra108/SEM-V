/*Implement a problem of smallest number with at least n
trailing zeroes in factorial.
Statement: Given a number n. The task is to find the smallest
number whose factorial contains at least n trailing zeroes.
Input : n = 1 Output : 5
Input : n = 6 Output : 25
 */


import java.util.Scanner;

public class Fact_trail_zero {
    public static int countTrailingZeroes(int num) {
        int count = 0;
        for (int i = 5; num / i >= 1; i *= 5) {
            count += num / i;
        }
        return count;
    }
    public static int findNum(int n) {
        if (n == 0)
            return 0;

        // Initialize variables
        int low = 0;
        int high = 5 * n;
        int mid;

        // Binary search for the smallest number whose factorial has at least n trailing zeroes
        while (low < high) {
            mid = (low + high) / 2;
            if (countTrailingZeroes(mid) < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n=sc.nextInt();
        System.out.println(findNum(n));
        sc.close();
    }
}



// overall timecomplexity = O((logn)^2)
