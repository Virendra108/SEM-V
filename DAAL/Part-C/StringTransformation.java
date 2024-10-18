import java.util.Scanner;

public class StringTransformation {
    public static boolean canTransform(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        // DP table: dp[i][j] is true if s1[0..i-1] can be transformed to s2[0..j-1]
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        // Base case: dp[0][0] = true (empty string to empty string)
        dp[0][0] = true;
        
        // Initialize the first column: transforming s1's prefix to an empty s2
        for (int i = 1; i <= n; i++) {
            if (Character.isLowerCase(s1.charAt(i - 1))) {
                dp[i][0] = dp[i - 1][0]; // We can delete lowercase letters
            } else {
                dp[i][0] = false; // Uppercase can't be deleted
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1]; // If characters match exactly
                } else if (Character.toUpperCase(c1) == c2 && Character.isLowerCase(c1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // If lowercase can be converted to uppercase
                }
                
                if (Character.isLowerCase(c1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j]; // Skip/deleting lowercase c1
                }
            }
        }
        
        // Return the final result: can we transform s1 to s2?
        return dp[n][m];
    }
    
    public static void main(String[] args) {
        String s1 = "daBcd";
        String s2 = "ABC";
        System.out.println(canTransform(s1, s2) ? "yes" : "no"); // Expected output: yes

        String s1_2 = "argaju";
        String s2_2 = "RAJ";
        System.out.println(canTransform(s1_2, s2_2) ? "yes" : "no"); // Expected output: yes
    }
}
