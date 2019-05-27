package com.winding_month.tree;

/**
 * 寻找两个节点的最低公共父节点
 * @author Eric
 */
public class LCA {

	/**
	 * 思路：
	 * 我们可以从根结点出发，判断当前结点的左右子树是否包含这两个结点。
	 * 如果左子树包含两个结点，则它们的最低公共祖先结点也一定在左子树中。
	 * 如果右子树包含两个结点，则它们的最低公共祖先结点也一定在右子树中。
	 * 如果一个结点在左子树，而另一个结点在右子树中，则当前结点就是它们的最低公共祖先结点
	 * 
	 * 时间复杂度围为O(n^2)
	 * 查找二叉树中两个结点最低公共祖先结点
     * struct node* LCA(struct node *root, struct node *p, struct node *q) 
     * {
     *     if (hasNode(root->left, p) && hasNode(root->left, q)) //p和q都在左子树中        
     *         return LCA(root->left, p, q);
     *     if (hasNode(root->right, p) && hasNode(root->right, q)) //p和q都在右子树中
     *         return LCA(root->right, p, q);
     *     return root; //p和q一个在左子树，一个在右子树中，直接返回root
     * }
     *  
     * 判断root为根的树是否包含结点p
     * bool hasNode(struct node* root, struct node* p)
     * {
     *     if (!root) return false;
     *     if (root == p)
     *         return true;
     *     return hasNode(root->left, p) ||  hasNode(root->right, p);
     * 
     * }
     * 
     * 
     * 还有一种自底向上的解法
     * 	 
     */
}
