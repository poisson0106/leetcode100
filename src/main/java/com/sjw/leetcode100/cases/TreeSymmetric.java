package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

import java.util.*;

public class TreeSymmetric implements BaseCase {
    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        isSymmetric(root);
    }

    public boolean isSymmetric(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        l = fl(root, l, true);
        r = fl(root, r, false);
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) != r.get(i)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> fr (TreeNode cur, List<Integer> res, boolean isRoot) {
        if (cur == null) {
            res.add(-101);
            return res;
        }

        res.add(cur.val);
        res = fr(cur.right, res, false);
        if (!isRoot)
            res = fr(cur.left, res, false);
        return res;
    }

    public List<Integer> fl (TreeNode cur, List<Integer> res, boolean isRoot) {
        if (cur == null) {
            res.add(-101);
            return res;
        }

        res.add(cur.val);
        res = fl(cur.left, res, false);
        if (!isRoot)
            res = fl(cur.right, res, false);
        return res;
    }
}
