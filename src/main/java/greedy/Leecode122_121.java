package greedy;

public class Leecode122_121 {
    /**
     * 122
     * 任何时候都只能持有一支股票，同一天可以买和卖
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int count = prices[i]-prices[i-1];
            if(count>0) sum+=count;
        }
        return sum;
    }

    public int maxProfit(int[] prices) {
        int result = 0,cur = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]-prices[cur]>0){
                result = Math.max(result,prices[i]-prices[cur]) ;
            }else if (prices[i]-prices[cur]<0){
                cur = i;
            }
        }
        return result;
    }
}
