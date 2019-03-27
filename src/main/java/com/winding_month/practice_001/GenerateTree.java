package com.winding_month.practice_001;

import java.util.HashMap;
import java.util.Map;

/**
 * 构建二叉树
 *                 1
 *         --------|-------
 *         2               3
 *     ----|----       ----|----
 *     4       5       6       7
 *
 * 前序遍历 1245367
 * 中序遍历 4251637
 * 后续遍历 4526731
 *
 * 以上面那棵二叉树为例，我们可以发现，对于后序遍历来说，最后一个元素一定是根节点，也就是1。
 * 然后我们在中序遍历的结果里面找到1所在的位置，那么它的左半部分就是其左子树，有半部分就是其右子树。
 *
 * 我们将中序遍历左半部分425取出，同时发现后序遍历的结果也在相应的位置上面，只是顺序稍微不一样，也就是452。
 * 我们可以发现，后序遍历中的2就是该子树的根节点。
 *
 * 上面说到了左子树，对于右子树，我们取出637，同时发现后序遍历中对应的数据偏移了一格，并且顺序也不一样，为673。
 * 而3就是这颗右子树的根节点。
 *
 * 重复上述过程，通过后续遍历找到根节点，然后在中序遍历数据中根据根节点拆分成两个部分，
 * 同时将对应的后序遍历的数据也拆分成两个部分，重复递归，就可以得到整个二叉树了
 *
 */
public class GenerateTree {

    public static void main(String[] args) {
        GenerateTree gt = new GenerateTree();
        int[] preorder = new int[]{1,2,4,5,3,6,7};
        int[] inorder = new int[]{4,2,5,1,6,3,7};
        int[] postorder = new int[]{4,5,2,6,7,3,1};
        TreeNode tn = gt.generateForPost(inorder, postorder);
        TreeNode tn1 = gt.generateForPre(preorder, inorder);
    }

    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    /**
     * 通过后序遍历和中序遍历数组  构造二叉树
     * @param inorder   中序
     * @param postorder   后序
     */
    private TreeNode generateForPost(int[] inorder, int[] postorder) {

        /** 树不存在 */
        if(postorder == null || postorder.length == 0) {
               return null;
        }

        for(int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
            postorder, 0, postorder.length - 1);


    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {

        if(inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode();
        root.setData(postorder[postEnd]);

        int mid = m.get(postorder[postEnd]);
        int distance = mid - inStart;

        root.setLeftNode(
                build(inorder, inStart, mid - 1,
                    postorder, postStart, postStart + distance - 1));

        root.setRightNode(
                build(inorder, mid + 1, inEnd,
                    postorder, postStart + distance , postEnd - 1));

        return root;
    }


    Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
    /**
     * 通过前序遍历和中序遍历数组构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    private TreeNode generateForPre(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0) {
            return null;
        }

        for(int i=0; i<inorder.length; i++) {
            m1.put(inorder[i], i);
        }

        return buildPre(inorder, 0, inorder.length - 1,
                preorder, 0, preorder.length - 1);
    }

    private TreeNode buildPre(int[] inorder, int inS, int inE,
                           int[] preorder, int preS, int preE) {

        if(inS > inE || preS > preE) {
            return null;
        }

        TreeNode rootPre = new TreeNode();
        rootPre.setData(preorder[preS]);

        int mid = m1.get(preorder[preS]);
        int num = mid - inS;

        rootPre.setLeftNode(
                buildPre(inorder, inS, mid - 1,
                        preorder, preS + 1, preS + num));

        rootPre.setRightNode(
                buildPre(inorder, mid + 1, inE,
                        preorder, preS + num + 1 , preE));

        return rootPre;
    }

    class TreeNode {
        private Object data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }
}
