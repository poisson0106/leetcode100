package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

public class BuildTree implements BaseCase {
    @Override
    public void run() {
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        TreeNode t = buildTree(preorder, inorder);
        System.out.println(t.val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        return f(preorder,inorder, 0, inorder.length-1, 0);
    }

    public TreeNode f (int[] preorder, int[] inorder, int begin, int end, int rootPos) {
        if (begin > end) {
            return null;
        }

        if (begin == end) {
            return new TreeNode(preorder[rootPos]);
        }

        TreeNode cur = new TreeNode(preorder[rootPos]);
        int mid = -1;
        for (int i = begin; i <= end; i++) {
            if(inorder[i] == cur.val){
                mid = i;
                break;
            }
        }

        int gap = mid - begin;

        TreeNode left = f(preorder,inorder,begin,mid-1, rootPos + 1);
        TreeNode right = f(preorder,inorder,mid+1,end, rootPos+gap+1);
        cur.left = left;
        cur.right = right;
        return cur;
    }
}
