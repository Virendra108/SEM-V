import java.util.*;
/*Implement Coin Change problem.
Statement Given an integer array of coins[ ] of size N representing
different types of currency and an integer sum, The task is to find
the number of ways to make sum by using different combinations
from coins[].
Note: Assume that you have an infinite supply of each type of
coin. */
public class Coin_change {
    public static int countWays(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[sum];
    }
    public static void main(String[] args) {
        int[] coins = {2,5,3,6}; // example coins array
        int sum = 10; // example sum
        
        int ways = countWays(coins, sum);
        System.out.println("Number of ways to make sum: " + ways);
    }
    

}
