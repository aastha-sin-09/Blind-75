class Solution {
    public int lengthOfLIS(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0) return 0;

        List<Integer> tails = new ArrayList<>();

        for(int num : nums){
            int insertPos = Collections.binarySearch(tails, num);

            if(insertPos < 0) 
                insertPos = -(insertPos + 1);

            if(insertPos == tails.size()){
               tails.add(num); 
            } 
            else{
                tails.set(insertPos,num);
            }
        }

        return tails.size();
    }
}
