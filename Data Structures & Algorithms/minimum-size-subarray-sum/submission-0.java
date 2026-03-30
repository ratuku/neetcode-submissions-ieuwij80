class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, l = 0;
        int window = Integer.MAX_VALUE;
        int r = 0;

        for (r = 0; r < nums.length ; r++) {
            // make window bigger until meets the requirement
            sum+= nums[r];

            // shorten the window until no longer meet requirement
            while (sum>= target) {
                window = Math.min(window, r - l + 1);
                sum-= nums[l];
                l++;
            }
        }

        return window == Integer.MAX_VALUE ? 0 : window;
    }
}