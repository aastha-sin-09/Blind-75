class Solution {
    public int rob(int[] nums) {
        //edge case 1:
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int max1 = robLinear(nums, 0, nums.length - 2); //include first house
        int max2 = robLinear(nums, 1, nums.length - 1); //exclude first house

        return Math.max(max1, max2);
    }

    public int robLinear(int[] nums, int start, int end){
        int rob1 = 0;
        int rob2 = 0;

        for(int i = start; i <= end; i++){
            int currMax = Math.max(nums[i] + rob1, rob2);

            rob1 = rob2;
            rob2 = currMax;
        }

        return rob2;
    }
}