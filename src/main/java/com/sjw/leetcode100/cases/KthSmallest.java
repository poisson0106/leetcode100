package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

public class KthSmallest implements BaseCase {

    private static int smallest;
    private static int kVal;

    @Override
    public void run() {

    }

    public int kthSmallest(TreeNode root, int k) {
        smallest = -1;
        kVal = k;
        f(root);
        return smallest;
    }

    public void f(TreeNode cur) {
        if (kVal== 0) {
            return;
        }

        if (cur == null) {
            return;
        }

        f(cur.left);
        kVal--;
        if (kVal == 0) {
            smallest = cur.val;
            return;
        }
        f(cur.right);
    }
}
