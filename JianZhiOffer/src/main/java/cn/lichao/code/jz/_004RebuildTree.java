package cn.lichao.code.jz;

public class _004RebuildTree {
    /*
    题目描述:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0) {
            return null;
        }
        return solute(pre, in, 0, pre.length-1, 0, in.length-1);

    }

    public TreeNode solute(int [] pre, int [] in, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (inBegin>inEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[preBegin]);
        int currPos=inBegin;
        for (; currPos<=inEnd; currPos++) {
            if (pre[preBegin] == in[currPos]) {
                break;
            }
        }
        treeNode.left = solute(pre, in, preBegin+1, preBegin+currPos-inBegin, inBegin, currPos-1);
        treeNode.right = solute(pre, in, preEnd-inEnd+currPos+1, preEnd, currPos+1, inEnd);
        return treeNode;
    }

}

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }