class Stock {
    public static int calculateMaxProfit(int[] rates) {
        int days = rates.length;
        int totalProfit = 0;

        for (int day = 1; day < days; day++) {
            // If today's price is greater than yesterday's, add the difference to the profit
            if (rates[day] > rates[day - 1]) {
                totalProfit += rates[day] - rates[day - 1];
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] stockRates1 = {2, 3, 5};
        int[] stockRates2 = {8, 5, 1};
        
        System.out.println(calculateMaxProfit(stockRates1));  // Output: 5
        System.out.println(calculateMaxProfit(stockRates2));  // Output: 0
    }
}
