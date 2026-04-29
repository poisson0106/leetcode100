package com.sjw.leetcode100.cases;

import com.sjw.leetcode100.base.BaseCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels implements BaseCase {
    @Override
    public void run() {
        List<Integer> lists = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(Arrays.toString(lists.toArray()));
    }

    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        //某个字母出现的最远的位置
        int[] farestPos = new int[26];
        Arrays.fill(farestPos, -1);

        for (int i = 0; i < chars.length; i++) {
            if (farestPos[chars[i] - 'a'] < i) {
                farestPos[chars[i] - 'a'] = i;
            }
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (farestPos[chars[i] - 'a'] > right) {
                right = farestPos[chars[i] - 'a'];
            }

            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
                right = i + 1;
            }
        }

        return res;
    }
}
