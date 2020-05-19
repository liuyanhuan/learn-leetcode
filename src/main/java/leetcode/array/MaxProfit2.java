package leetcode.array;

import java.util.Arrays;

/**
 * <p>给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。</p>
 * <p>设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。</p>
 * <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>
 */
public class MaxProfit2 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0; i< prices.length-1; i++) {
            if(prices[i]<prices[i+1]) {
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

  public static void main(String[] args) {
    int[] nums = new int[] {7,1,5,3,6,4};
      int i = maxProfit(nums);
    System.out.println(i);
    System.out.println(Arrays.toString(nums));
  }
}
