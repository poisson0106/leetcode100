package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

public class TreeFlatten implements BaseCase {

    private TreeNode curLeftest;

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
    }

    public void flatten(TreeNode root) {
        f(root);
        TreeNode cur = root;
        while (cur != null) {
            cur.right = cur.left;
            cur.left = null;
            cur = cur.right;
        }

        cur = root;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    public TreeNode f(TreeNode cur) {
        if (cur == null) {
            return cur;
        }

        TreeNode left = f(cur.left);
        if (left == null) {
            curLeftest = cur;
        }

        TreeNode right = cur.right;
        if (right == null) {
            return cur;
        } else {
            curLeftest.left = cur.right;
            cur.right = null;
            f(curLeftest);
            return cur;
        }
    }
}
