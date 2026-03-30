class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1;
        int max_diff = 0;

        while(right < prices.length) {
            if (prices[left] < prices[right]) {
                int local_diff = prices[right] - prices[left];
                max_diff = Math.max(local_diff, max_diff);
            } else {
                left = right;
            }
            right++;
        }

        return max_diff;
    }
}


/// 3, ,4, 7, 4,1