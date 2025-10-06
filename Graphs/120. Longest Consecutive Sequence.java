class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums){
            numSet.add(num);
        }

        Set<Integer> visited = new HashSet<>();
        int longestStreak = 0;

        for(int num : nums){
            if(!visited.contains(num)){
                int currStreak = dfs(num, numSet, visited);
                longestStreak = Math.max(currStreak, longestStreak);
            }
        }

        return longestStreak;
    }

    public int dfs(int num, Set<Integer> numSet, Set<Integer> visited){
        if(visited.contains(num) || !numSet.contains(num)){
            return 0;
        }

        visited.add(num);

        int left = dfs(num - 1, numSet, visited);
        int right = dfs(num + 1, numSet, visited);

        return 1 + left + right;
    }
}