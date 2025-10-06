class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null || p.val != q.val){
            return false;
        }

        //recursively check for both the children
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}