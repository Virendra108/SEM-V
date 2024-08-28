import java.util.Arrays;

class MaxShops {
    public static int MaximumShops(int[] opening, int[] closing, int n, int k) {
        // Create and sort pairs of opening and closing times
        int[][] shops = new int[n][2];
        for (int i = 0; i < n; i++) {
            shops[i][0] = opening[i];
            shops[i][1] = closing[i];
        }
        Arrays.sort(shops, (a, b) -> a[1] - b[1]);

        // Track end times of K people
        int[] endTimes = new int[k];
        Arrays.fill(endTimes, -1); // Initialize with -1 (no shops visited)

        int count = 0;

        for (int[] shop : shops) {
            // FInding the first person to visit the shop or first non engaged person
            for (int i = 0; i < k; i++) {
                if (endTimes[i] <= shop[0]) {
                    endTimes[i] = shop[1]; // Assign this shop's end time to that person
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] S = {1, 8, 3, 2, 6};
        int[] E = {5, 10, 6, 5, 9};
        int K = 2;
        System.out.println(MaximumShops(S, E, S.length, K));  
        
        int[] S1 = {1, 2, 3};
        int[] E1 = {3, 4, 5};
        int K1 = 2;
        System.out.println(MaximumShops(S1, E1, S1.length, K1));
        
        //OUTPUTS 4  and 3
    }
}
