package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;
import com.sjw.leetcode100.base.TreeNode;

public class TreeSortedArrayToBST implements BaseCase {
    @Override
    public void run() {
        TreeNode root = sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return new TreeNode(nums[0]);
        } else {
            return f(0, n-1, nums);
        }
    }

    public TreeNode f(int begin, int end, int[] nums) {
        if (begin == end) {
            return new TreeNode(nums[begin]);
        }

        if (begin > end) {
            return null;
        }
        int mid = (begin + end + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = f(begin, mid-1, nums);
        node.right = f(mid+1, end, nums);
        return node;
    }
}
