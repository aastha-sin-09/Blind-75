class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        find(candidates,target,result,new ArrayList<>(),0);

        return result;
    }

    public void find(int[] candidates,int remainingTarget,List<List<Integer>> result,List<Integer> curr,int idx){
        if(remainingTarget == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(remainingTarget < 0){
            return;
        }

        //choose,explore,unchoose
        for(int i = idx; i < candidates.length; i++){

            //choose
            curr.add(candidates[i]);

            //explore
            find(candidates,remainingTarget - candidates[i],result,curr,i);

            //unchoose
            curr.remove(curr.size() - 1);
        }

    }
}