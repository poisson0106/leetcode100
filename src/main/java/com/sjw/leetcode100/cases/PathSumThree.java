package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

import java.util.HashMap;

public class PathSumThree implements BaseCase {
    @Override
    public void run() {
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);
        pathSum(root, 0);
        System.out.println(result);
    }

    private int result;

    public int pathSum(TreeNode root, int targetSum) {
        result = 0;
        HashMap<Long, Integer> presums = new HashMap<>();
        //什么都不选也是一种情况
        presums.put(0l, 1);
        f(root, targetSum, 0, presums);
        return result;
    }

    public void f(TreeNode node, int targetSum, long currentSum, HashMap<Long, Integer> presums) {
        if (node == null) {
            return;
        }

        //本质是前缀和题目
        //当前位置的前缀和
        long newSum = currentSum + node.val;
        long tar = newSum - targetSum;
        //如果存在差值，说明某个位置的到当前位置之间是符合要求的
        if (presums.containsKey(tar)) {
            result += presums.get(tar);
        }

        if (presums.containsKey(newSum)) {
            presums.put(newSum,presums.get(newSum)+1);
        } else {
            presums.put(newSum, 1);
        }

        f(node.left,targetSum,newSum,presums);
        f(node.right,targetSum,newSum,presums);

        presums.put(newSum,presums.get(newSum)-1);
    }
}
