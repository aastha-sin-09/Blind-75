class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int remaining = target - nums[i];
            if(map.containsKey(remaining)){
                ans[0] = map.get(remaining);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i); //key, value
        }
        return ans;
    }
}