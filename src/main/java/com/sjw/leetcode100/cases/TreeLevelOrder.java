package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrder implements BaseCase {
    @Override
    public void run() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode tmp = null;
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            list.add(tmp.val);
            currentLevelCount--;
            if (tmp.left != null) {
                queue.add(tmp.left);
                nextLevelCount++;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                nextLevelCount++;
            }

            if (currentLevelCount == 0) {
                res.add(list);
                list = new ArrayList<>();
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }

        return res;
    }
}
