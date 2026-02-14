package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

public class TreeMaxDepth implements BaseCase {

    private int maxDepth;

    @Override
    public void run() {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            f(root,1);
        }
        return maxDepth;
    }

    public void f(TreeNode cur, int depth) {
        if (cur.left == null && cur.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            return ;
        }

        if (cur.left != null)
            f(cur.left, depth + 1);
        if (cur.right != null)
            f(cur.right, depth + 1);
    }
}
