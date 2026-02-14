package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView implements BaseCase {
    @Override
    public void run() {

    }

    public List<Integer> rightSideView(TreeNode root) {
        //bfs, 每一层最右侧就是所求

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        int size = 1;
        TreeNode cur = root;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size-1; i++) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            cur = queue.poll();
            res.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return res;
    }
}
