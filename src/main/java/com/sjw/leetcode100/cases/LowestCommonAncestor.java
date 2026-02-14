package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor implements BaseCase {

    private TreeNode result;

    @Override
    public void run() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode r = lowestCommonAncestor(root, new TreeNode(4), new TreeNode(6));
        System.out.println(r.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        f(root, p, q);
        return result;
    }

    public boolean f(TreeNode cur, TreeNode p, TreeNode q) {

        if (cur == null) {
            return false;
        }

        boolean leftContains= f(cur.left, p, q);
        boolean rightContains = f(cur.right, p, q);

        if ((leftContains && rightContains) || ((cur.val == p.val || cur.val == q.val) && (leftContains || rightContains))) {
            result = cur;
        }

        return leftContains || rightContains || cur.val == p.val || cur.val == q.val;
    }
}
