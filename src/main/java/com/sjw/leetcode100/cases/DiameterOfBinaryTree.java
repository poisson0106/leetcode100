package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree implements BaseCase {

    private int max;

    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        diameterOfBinaryTree(root);
        System.out.println(max);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        max = Integer.MIN_VALUE;
        f(root);
        return max;
    }

    public int f(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int left = f(cur.left);
        int right = f(cur.right);

        if (left + right> max) {
            max = left + right;
        }

        return Math.max(left, right) + 1;
    }
}
