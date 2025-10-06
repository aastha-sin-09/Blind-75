class Solution {
    Map<Integer, Integer> inorderMap;
    int postOrderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postOrderIndex = postorder.length - 1;

        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] postorder, int left, int right) {
        if(left > right){
            return null;
        }

        int rootVal = postorder[postOrderIndex];
        TreeNode root = new TreeNode(rootVal);

        postOrderIndex--;

        int inorderRootIndex = inorderMap.get(rootVal);

        root.right = build(postorder, inorderRootIndex + 1, right);
        root.left = build(postorder, left, inorderRootIndex - 1);

        return root;
    }
}