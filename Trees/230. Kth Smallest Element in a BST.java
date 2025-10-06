class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode currNode = root;

        while(currNode != null || !stack.isEmpty()){
            while(currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }

            currNode = stack.pop();
            k--;
            if(k == 0){
                return currNode.val;
            }

            currNode = currNode.right;
        }
        return -1;
    }
}