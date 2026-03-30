class Solution {
    public int search(int[] nums, int target) {
        int lower_index = 0;
        int upper_index = nums.length-1;
        int index = upper_index/2;

        while (index <= upper_index && index >= lower_index) { 
            // should be when the cross just submit to test?
            if(target == nums[index]) {
                return index;
            }
            else if(target > nums[index]) {
                lower_index = index + 1;
            }
            else if(target < nums[index]) {
                upper_index = index -1;
            }
            index = lower_index + (upper_index - lower_index)/2;
        }
        return -1;
    }
}
