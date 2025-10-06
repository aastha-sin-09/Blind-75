class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currNode = root;

        while(currNode != null){
            if(p.val > currNode.val && q.val > currNode.val){
                currNode = currNode.right;
            }

            else if(p.val < currNode.val && q.val < currNode.val){
                currNode = currNode.left;
            }

            else{
                return currNode;
            }
        }

        return null;
        
    }
}