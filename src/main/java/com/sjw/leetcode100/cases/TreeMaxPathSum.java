package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

public class TreeMaxPathSum implements BaseCase {

    class Info {
        int leftMax;
        int rightMax;

        public Info(int leftMax, int rightMax) {
            this.leftMax = leftMax;
            this.rightMax = rightMax;
        }
    }

    private int max;

    @Override
    public void run() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-2);
        maxPathSum(root);
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        f(root);
        return max;
    }

    private Info f(TreeNode cur) {
        if (cur == null) {
            return new Info(0,0);
        }

        Info leftTreeInfo = f(cur.left);
        Info rightTreeInfo = f(cur.right);

        int leftMax = Math.max(leftTreeInfo.leftMax, leftTreeInfo.rightMax) + cur.val;
        int rightMax = Math.max(rightTreeInfo.leftMax, rightTreeInfo.rightMax) + cur.val;

        int curMax = Math.max(Math.max(leftMax, rightMax), leftMax+rightMax-cur.val);

        if (cur.val > curMax) {
            curMax = cur.val;
            leftMax = cur.val;
            rightMax = cur.val;
        }

        if (curMax > max) {
            max = curMax;
        }

        return new Info(leftMax, rightMax);
    }
}
