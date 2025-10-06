class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null); //null represents -infi +infi
    }

    public boolean validate(TreeNode node, Integer lower, Integer upper){
        //base case: null node is a BST
        if(node == null) return true;

        if(lower != null && node.val <= lower){
            return false;
        }

        if(upper != null && node.val >= upper){
            return false;
        }

        return validate(node.left, lower, node.val) &&
                validate(node.right, node.val, upper);
    }
}