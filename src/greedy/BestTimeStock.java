package greedy;

public class BestTimeStock {
    public int maxProfit(int[] prices) {
        int res = 0, buy = prices[0];

        for (int i=1; i<prices.length; i++) {
            res = Math.max(res, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }

        return res;
    }
}
