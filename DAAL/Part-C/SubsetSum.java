import java.util.*;
/*Implement Subset Sum Problem.
Statement Given a set of non-negative integers and a value sum,
the task is to check if there is a subset of the given set whose sum is
equal to the given sum.
Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9 Output: True
Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30 Output: False */
public class SubsetSum {
    public static boolean isSubsetSum(int[] set, int sum) {
        boolean[][] dp = new boolean[set.length + 1][sum + 1];
        
        for (int i = 0; i <= set.length; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= set.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (set[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[set.length][sum];
    }
    public static void main(String[] args) {
        int set1[] = {3, 34, 4, 12, 5, 2};
        int sum1 = 9;
        System.out.println(isSubsetSum(set1, sum1));
        int set2[] = {3, 34, 4, 12, 5, 2};
        int sum2 = 30;
        System.out.println(isSubsetSum(set2, sum2));
    }
}
