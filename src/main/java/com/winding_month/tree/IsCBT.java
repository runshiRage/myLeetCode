package com.winding_month.tree;

/** 判断一棵树是不是完全二叉树 */
public class IsCBT {

	/**
	 * bool IsCBT(Node * node)
		{
		    bool flag = false;
		    queue<Node*> Q;
		    Q.push(node);
		  
		    while (!Q.empty())
		    {
		        Node * p = Q.front();
		        Q.pop();
		      
		        if (flag)
		        {
		            if (p->left || p->right)
		                return false;
		        }
		        else
		        {
		            if (p->left && p->right)
		            {
		                Q.push(p->left);
		                Q.push(p->right);
		            }
		            else if (p->right)  // 只有右结点
		                return false;
		            else if (p->left)   // 只有左结点
		            {
		                Q.push(p->left);
		                flag = true;
		            }
		            else  // 没有结点
		                flag = true;
		        }
		    }
		    return true;
		}
	 */
	
	//java
	
	/**
	 * 判断一颗树是不是二叉查找树
	 * bool IsBST(Node * node, int min, int max)
		{
		    if (node == nullptr)
		        return true;
		    if (node->data <= min || node->data >= max)
		        return false;
		  
		    return IsBST(node->left, min, node->data) && IsBST(node->right, node->data, max);
		}
		
		IsBST(node, INT_MIN, INT_MAX);
	 * 
	 * 也可以通过一棵树的中序遍历元素是递增的这个特征来判断
	 * 
	 */
	
	
	/**
	 * 根据前序遍历和中序遍历  推算后序遍历
	 * 前序遍历和中序遍历结果以长度为 n 的数组存储，pos1 为前序数组下标，pos2 为后序下标 

		int pre_order_arry[n];
		int in_order_arry[n];
		
		void PrintPostOrder(int pos1, int pos2, int n)
		{
		    if (n == 1)
		    {
		        cout << pre_order_arry[pos1];
		        return;
		    }
		    if (n == 0)
		        return;
		  
		    int i = 0;
		    for (; pre_order_arry[pos1] != in_order_arry[pos2 + i]; i++)
		        ;
		  
		    PrintPostOrder(pos1 + 1, pos2, i);
		    PrintPostOrder(pos1 + i + 1, pos2 + i + 1, n - i - 1);
		    cout << pre_order_arry[pos1];
		}
	 */
	
	
}
