package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

public class TreeInvertTree implements BaseCase {
    @Override
    public void run() {

    }

    public TreeNode invertTree(TreeNode root) {
        f(root);
        return root;
    }

    public void f(TreeNode cur) {
        if (cur == null) {
            return;
        }

        TreeNode tmp = cur.left;
        cur.left = cur.right;
        cur.right = tmp;

        f(cur.left);
        f(cur.right);
    }
}
