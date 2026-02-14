package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

public class CheckValidBST implements BaseCase {

    private long min;
    private long max;

    @Override
    public void run() {
        TreeNode treeNode = new TreeNode(-2147483648);
        treeNode.right = new TreeNode(2147483647);
        System.out.println(isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        return f(root);
    }

    public boolean f(TreeNode cur) {
        if (cur == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }

        boolean left = f(cur.left);
        long lmin = min;
        long lmax = max;
        boolean right = f(cur.right);
        long rmin = min;
        long rmax = max;
        min = Long.min(Long.min(lmin, rmin), cur.val);
        max = Long.max(Long.max(lmax, rmax), cur.val);

        return left && right && cur.val > lmax && cur.val < rmin;
    }
}
